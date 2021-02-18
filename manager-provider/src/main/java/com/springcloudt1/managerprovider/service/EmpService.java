package com.springcloudt1.managerprovider.service;

import com.springcloudt1.managerprovider.dao.DeptDao;
import com.springcloudt1.managerprovider.dao.EmpDao;
import com.springcloudt1.managerapi.entity.Emp;
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
    private final String user_id="emp:id:";
     public List initRoles(){
         List roles;
         if(redisUtils.hasKey("roles")){
             roles =(List)redisUtils.get("roles");
         }else{
             roles = roleinfoDao.show();
             redisUtils.set("roles",roles,800);
         }
         return roles;
  }


    public List loadDept(){
        List depts;
        if(redisUtils.hasKey("depts")){
            depts=(List) redisUtils.get("depts");
        }else{
            depts =  deptDao.show();
            redisUtils.set("depts",depts,800);
        }
        return depts;
    }
    public List pager(int pageNo,int pageSize) {
        Map map = new HashMap();
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        List all = dao.page(map);
        return all;
    }
    public List search(String name){return dao.search(name);}

    public List show(){
        return  dao.show();
    }
}
