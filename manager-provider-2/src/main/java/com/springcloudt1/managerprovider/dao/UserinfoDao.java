package com.springcloudt1.managerprovider.dao;

import com.springcloudt1.managerapi.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
@Mapper
public interface UserinfoDao {
    int deleteByPrimaryKey (Integer id);

    Object selectMa (Map map);

    int insert (Userinfo record);

    int insertSelective (Userinfo record);

    Userinfo selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Userinfo record);

    int updateByPrimaryKey (Userinfo record);
}