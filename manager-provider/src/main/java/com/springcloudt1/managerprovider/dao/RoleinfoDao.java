package com.springcloudt1.managerprovider.dao;

import com.springcloudt1.managerapi.entity.Roleinfo;
import com.springcloudt1.managerapi.entity.Roleinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleinfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Roleinfo record);

    List show();

    int insertSelective(Roleinfo record);

    Roleinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Roleinfo record);

    int updateByPrimaryKey(Roleinfo record);
}