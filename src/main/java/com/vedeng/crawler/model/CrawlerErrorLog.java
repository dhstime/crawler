package com.vedeng.crawler.model;

import java.util.Date;

public class CrawlerErrorLog {
    /** 爬虫日志表  CRAWLER_ERROR_LOG_ID **/
    private Integer crawlerErrorLogId;

    /** 运行的爬虫种类  CLASS_NAME **/
    private String className;

    /** 错误页数  PAGE_NUM **/
    private Integer pageNum;

    /** 是否补偿成功   0否  1是  IS_ENABLE **/
    private Boolean isEnable;

    /** 添加时间  ADD_TIME **/
    private Date addTime;

    /** 添加人  CREATOR **/
    private String creator="crawler";

    /** 修改时间  MODE_TIME **/
    private Date modeTime;

    /** 修改人  UPDATER **/
    private String updater="crawler";

    /** 是否删除  0否  1是  IS_DELETE **/
    private Boolean isDelete;

    /** 1子页面数据错误  2线程错误  OPT_TYPE **/
    private Integer optType;

    public CrawlerErrorLog() {
    }

    public CrawlerErrorLog(String className, Integer pageNum, Integer optType) {
        this.className = className;
        this.pageNum = pageNum;
        this.optType = optType;
    }

    /**   爬虫日志表  CRAWLER_ERROR_LOG_ID   **/
    public Integer getCrawlerErrorLogId() {
        return crawlerErrorLogId;
    }

    /**   爬虫日志表  CRAWLER_ERROR_LOG_ID   **/
    public void setCrawlerErrorLogId(Integer crawlerErrorLogId) {
        this.crawlerErrorLogId = crawlerErrorLogId;
    }

    /**   运行的爬虫种类  CLASS_NAME   **/
    public String getClassName() {
        return className;
    }

    /**   运行的爬虫种类  CLASS_NAME   **/
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**   错误页数  PAGE_NUM   **/
    public Integer getPageNum() {
        return pageNum;
    }

    /**   错误页数  PAGE_NUM   **/
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**   是否补偿成功   0否  1是  IS_ENABLE   **/
    public Boolean getIsEnable() {
        return isEnable;
    }

    /**   是否补偿成功   0否  1是  IS_ENABLE   **/
    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    /**   添加时间  ADD_TIME   **/
    public Date getAddTime() {
        return addTime;
    }

    /**   添加时间  ADD_TIME   **/
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**   添加人  CREATOR   **/
    public String getCreator() {
        return creator;
    }

    /**   添加人  CREATOR   **/
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**   修改时间  MODE_TIME   **/
    public Date getModeTime() {
        return modeTime;
    }

    /**   修改时间  MODE_TIME   **/
    public void setModeTime(Date modeTime) {
        this.modeTime = modeTime;
    }

    /**   修改人  UPDATER   **/
    public String getUpdater() {
        return updater;
    }

    /**   修改人  UPDATER   **/
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**   是否删除  0否  1是  IS_DELETE   **/
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**   是否删除  0否  1是  IS_DELETE   **/
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

}