package com.springcloudt1.managerprovider.service;

import com.springcloudt1.managerapi.entity.Emp;
import com.springcloudt1.managerprovider.dao.DeptDao;
import com.springcloudt1.managerprovider.dao.EmpDao;
import com.springcloudt1.managerprovider.dao.RoleinfoDao;
import com.springcloudt1.managerprovider.utils.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpService {
    @Resource
    EmpDao dao;
    @Resource
    DeptDao deptDao;
    @Resource
    RedisUtils redisUtils;
    @Resource
    RoleinfoDao roleinfoDao;
    @Resource
    MsgAdd msgAdd;
    private final String user_id="emp:id:";
    public void add (Emp data) {
        data.setPwd("111111");
        dao.insert(data);
        if (!redisUtils.hasKey(user_id + data.getId())) {
            redisUtils.set(user_id + data.getId(), data, 3600);
        }
        msgAdd.convertObj("ex_emp","emp_add",data);
    }

    public void del (int id) {
        if(redisUtils.hasKey(user_id+id)){
            redisUtils.del(user_id+id);
        }
        msgAdd.convertObj("ex_emp","emp_del",id);
        dao.deleteByPrimaryKey(id);
    }

    public void update (Emp data) {
        redisUtils.set(user_id + data.getId(), data, 3600);
        dao.updateByPrimaryKey(data);
        msgAdd.convertObj("ex_emp","emp_update",data);
    }

    public void dellAll(int[] records) {
        msgAdd.convertObj("ex_emp","emp_delAll",records);
        for (int id : records) {
            if (redisUtils.hasKey(user_id + id)) {
                redisUtils.del(user_id + id);
            }
           dao.deleteByPrimaryKey(id);
        }
    }
    }

