package com.springcloudt1.managerprovider.service;

import com.springcloudt1.managerapi.entity.Dept;
import com.springcloudt1.managerprovider.dao.DeptDao;
import com.springcloudt1.managerprovider.utils.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptService {
    @Resource
    DeptDao dao;
    @Resource
    RedisUtils redisUtils;
    @Resource
    MsgAdd msgAdd;
    private final String user_id="dept:id:";
   public void add(Dept data){
       dao.insert(data);
       msgAdd.convertObj("ex_dept","dept_add",data);
       if(!redisUtils.hasKey(user_id+data.getId())){
           redisUtils.set(user_id+data.getId(),data,3600);
       }

   }
   public void del(int id){
       if(redisUtils.hasKey(user_id+id)){
           redisUtils.del(user_id+id);
       }
       msgAdd.convertObj("ex_dept","dept_del",id);
       dao.deleteByPrimaryKey(id);
   }

   public void update(Dept data){

       redisUtils.set(user_id+data.getId(),data,3600);
       msgAdd.convertObj("ex_dept","dept_update",data);
       dao.updateByPrimaryKey(data);
   }


   public void delAll(int[] records) {
       msgAdd.convertObj("ex_dept","dept_delAll",records);
       for (int id : records) {
           if (redisUtils.hasKey(user_id + id)) {
               redisUtils.del(user_id + id);
           }
          dao.deleteByPrimaryKey(id);
       }
   }
}
