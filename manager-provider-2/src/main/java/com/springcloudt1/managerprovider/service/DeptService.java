package com.springcloudt1.managerprovider.service;

import com.springcloudt1.managerprovider.dao.DeptDao;
import com.springcloudt1.managerapi.entity.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DeptService {
    @Resource
    DeptDao dao;
   public void add(Dept data){
       dao.insert(data);
   }

   public void del(int id){
       dao.deleteByPrimaryKey(id);
   }

   public void update(Dept data){
       dao.updateByPrimaryKey(data);
   }
   public Dept load(int id){
    Dept data = dao.selectByPrimaryKey(id);
    return data;
   }
   public List pager(Map map){
       List all = dao.pager(map);
       return all;
   }
   public List check(String name){
       return dao.check(name);
   }
   public List show(){
       List all = dao.show();
       return all;
   }
}
