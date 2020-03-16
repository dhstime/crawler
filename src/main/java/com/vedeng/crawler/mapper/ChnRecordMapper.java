package com.vedeng.crawler.mapper;

import com.vedeng.crawler.model.ChnRecord;

public interface ChnRecordMapper {


    int insert(ChnRecord record);


    int updateByPrimaryKey(ChnRecord record);

    int updateByPrimaryKeySelective(ChnRecord record);

    ChnRecord getChnRecordByNumber(ChnRecord chnRecord);
}