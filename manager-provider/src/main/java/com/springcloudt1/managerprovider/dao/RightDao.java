package com.springcloudt1.managerprovider.dao;

import com.springcloudt1.managerapi.entity.Right;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RightDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Right record);

    List init();

    int insertSelective(Right record);

    Right selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Right record);

    int updateByPrimaryKey(Right record);
}