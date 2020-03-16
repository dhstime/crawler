package com.vedeng.crawler.mapper;

import com.vedeng.crawler.model.CrawlerErrorLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CrawlerErrorLogMapper {
    int deleteByPrimaryKey(Integer crawlerErrorLogId);

    int insert(CrawlerErrorLog record);

    int insertSelective(CrawlerErrorLog record);

    CrawlerErrorLog selectByPrimaryKey(Integer crawlerErrorLogId);

    int updateByPrimaryKeySelective(CrawlerErrorLog record);

    int updateByPrimaryKey(CrawlerErrorLog record);
    /**
    *   获取失败日志页数
    * @Author:strange
    * @Date:13:29 2020-03-16
     * @param type
    */
    List<CrawlerErrorLog> getErrorList(@Param("type") String type);

    Integer updateEnable(Integer id);
}