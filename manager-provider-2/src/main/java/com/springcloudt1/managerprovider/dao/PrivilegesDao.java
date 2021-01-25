package com.springcloudt1.managerprovider.dao;

import com.springcloudt1.managerapi.entity.Privileges;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
@Mapper
public interface PrivilegesDao {
    int insert (Privileges record);
    void del (int role_id);
    int insertSelective (Privileges record);
    void grant (Map map);
}