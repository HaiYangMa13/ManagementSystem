package com.springcloudt1.managerprovider.service;

import com.springcloudt1.managerprovider.dao.DeptDao;
import com.springcloudt1.managerapi.entity.Dept;
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
    private final String user_id="dept:id:";
   public void add(Dept data){
       dao.insert(data);
       if(!redisUtils.hasKey(user_id+data.getId())){
           redisUtils.set(user_id+data.getId(),data,3600);
       }
   }

   public void del(int id){
       if(redisUtils.hasKey(user_id+id)){
           redisUtils.del(user_id+id);
       }
       dao.deleteByPrimaryKey(id);
   }

   public void update(Dept data){
       redisUtils.set(user_id+data.getId(),data,3600);
       dao.updateByPrimaryKey(data);
   }
   public Dept load(int id){
       Dept record;
       if(redisUtils.hasKey(user_id+id)){
           record=(Dept)redisUtils.get(user_id+id);
       }else{
           record = dao.selectByPrimaryKey(id);
           redisUtils.set(user_id+id,record,3600);
       }
    return record;
   }
   public List pager(int pageNo,int pageSize){
       Map map = new HashMap();
       System.out.println(pageNo+""+pageSize);
       map.put("pageNo",(pageNo-1)*pageSize);
       map.put("pageSize",pageSize);
       List all = dao.pager(map);
       return all;
   }
   public void delAll(int[] records) {
       for (int id : records) {
           if (redisUtils.hasKey(user_id + id)) {
               redisUtils.del(user_id + id);
           }
          dao.deleteByPrimaryKey(id);
       }
   }
   public List check(String name){
       return dao.check(name);
   }
   public List show(){
       List all = dao.show();
       return all;
   }
}
