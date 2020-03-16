package com.vedeng.crawler.mapper;

import com.vedeng.crawler.model.ForeRegister;

public interface ForeRegisterMapper {

    int insert(ForeRegister record);

    int updateByPrimaryKey(ForeRegister record);

    int updateByPrimaryKeySelective(ForeRegister record);

    ForeRegister getForeRegisterByNumber(ForeRegister foreRegister);
}