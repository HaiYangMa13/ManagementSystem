package com.springcloudt1.managerprovider.dao;

import com.springcloudt1.managerapi.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface EmpDao {
    int deleteByPrimaryKey (Integer id);

    int insert (Emp record);

    int countId ();

    List search (String name);

    Emp selectEM (Map map);

    List show ();

    List serch (String name);

    List page (Map map);

    int insertSelective (Emp record);

    Emp selectByPrimaryKey (Integer id);

    int updateByPrimaryKeySelective (Emp record);

    int updateByPrimaryKey (Emp record);
}