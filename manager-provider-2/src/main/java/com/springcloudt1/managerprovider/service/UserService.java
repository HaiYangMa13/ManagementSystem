package com.springcloudt1.managerprovider.service;

import com.springcloudt1.managerprovider.dao.EmpDao;
import com.springcloudt1.managerprovider.dao.UserinfoDao;
import com.springcloudt1.managerapi.entity.Emp;
import com.springcloudt1.managerapi.entity.Roleinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

@Service
public class UserService {
    @Resource
    EmpDao dao;
    @Resource
    UserinfoDao userinfoDao;

    public Emp loadOthers(Map map){
      return dao.selectEM(map);
    }

    public Object loadManager(Map map){
        return userinfoDao.selectMa(map);
    }

}
