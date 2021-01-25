package com.springcloudt1.managerprovider.service;

import com.springcloudt1.managerprovider.dao.PrivilegesDao;
import com.springcloudt1.managerprovider.dao.RightDao;
import com.springcloudt1.managerprovider.dao.RoleinfoDao;
import com.springcloudt1.managerapi.entity.Roleinfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PermissionService {
    @Resource
    RightDao rightDao;
    @Resource
    RoleinfoDao roleinfoDao;
    @Resource
    PrivilegesDao privilegesDao;
    public List init(){
      return   rightDao.init();
    }

    public List initRoles(){
      return  roleinfoDao.show();
    }
    public Roleinfo loadRole (int roleid){
       Roleinfo roleinfo = roleinfoDao.selectByPrimaryKey(roleid);
       return  roleinfo;
    }

    public void clear(int role_id){
        privilegesDao.del(role_id);
    }

    public void grant(Map map){
        privilegesDao.grant(map);
    }
}
