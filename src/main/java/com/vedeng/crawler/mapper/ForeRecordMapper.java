package com.vedeng.crawler.mapper;

import com.vedeng.crawler.model.ForeRecord;

public interface ForeRecordMapper {

    int insert(ForeRecord record);


    int updateByPrimaryKey(ForeRecord record);

    int updateByPrimaryKeySelective(ForeRecord record);

    ForeRecord getForeRecordByNumber(ForeRecord foreRecord);
}