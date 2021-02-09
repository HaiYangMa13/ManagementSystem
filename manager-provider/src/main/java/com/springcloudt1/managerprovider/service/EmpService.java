package com.springcloudt1.managerprovider.service;

import com.springcloudt1.managerprovider.dao.DeptDao;
import com.springcloudt1.managerprovider.dao.EmpDao;
import com.springcloudt1.managerapi.entity.Emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EmpService {
    @Resource
    EmpDao dao;
    @Resource
    DeptDao deptDao;
    public void add (Emp data) {
        dao.insert(data);
    }

    public void del (int id) {
        dao.deleteByPrimaryKey(id);
    }

    public void update (Emp data) {
        dao.updateByPrimaryKey(data);
    }

    public List loadDept(){
        return deptDao.show();
    }

    public Emp findByEmpNo(String name){
        return dao.findbyEmpNo(name);
    }

    public List pager (Map map) {
        List all = dao.page(map);
        return all;
    }
    public List search(String name){return dao.search(name);}

    public int countId () {
        int record = dao.countId();
        return record;
    }
    public Emp findById(int id){
       return dao.selectByPrimaryKey(id);
    }

    public List serch(String name){
        return dao.serch(name);
    }

    public List show(){
        return  dao.show();
    }
}
