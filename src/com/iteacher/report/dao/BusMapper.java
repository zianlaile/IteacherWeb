package com.iteacher.report.dao;

import com.iteacher.report.model.Bus;

public interface BusMapper {
    int deleteByPrimaryKey(Integer busid);

    int insert(Bus record);

    int insertSelective(Bus record);

    Bus selectByPrimaryKey(Integer busid);

    int updateByPrimaryKeySelective(Bus record);

    int updateByPrimaryKey(Bus record);
}