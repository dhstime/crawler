package com.vedeng.crawler.mapper;

import com.vedeng.crawler.model.ChnRegister;

public interface ChnRegisterMapper {

    int insert(ChnRegister record);

    int updateByPrimaryKeySelective(ChnRegister record);

    ChnRegister getChnRegisterByNumber(ChnRegister chnRegister);
}