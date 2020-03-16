package com.vedeng.crawler.mapper;

import com.vedeng.crawler.model.CrawlerErrorLog;

public interface CrawlerErrorLogMapper {
    int deleteByPrimaryKey(Integer crawlerErrorLogId);

    int insert(CrawlerErrorLog record);

    int insertSelective(CrawlerErrorLog record);

    CrawlerErrorLog selectByPrimaryKey(Integer crawlerErrorLogId);

    int updateByPrimaryKeySelective(CrawlerErrorLog record);

    int updateByPrimaryKey(CrawlerErrorLog record);
}