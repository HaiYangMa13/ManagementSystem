package com.springcloudt1.managerprovider.dao;

import com.springcloudt1.managerapi.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeptDao {
    int deleteByPrimaryKey (Integer id);

    int insert (Dept record);

    List show ();
    List pager (Map map);
    List check (String name);

    int insertSelective (Dept record);

    Dept selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Dept record);

    int updateByPrimaryKey (Dept record);
}