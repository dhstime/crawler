package com.vedeng.crawler.model;

import com.vedeng.crawler.common.annotation.Extract;
import com.vedeng.crawler.common.annotation.SeleniumDocument;
import com.vedeng.crawler.common.queue.QueueTaskHandler;
import com.vedeng.crawler.common.queue.SpringUtils;
import com.vedeng.crawler.service.crawler.CrawlerService;

import java.util.Date;

/**
*国产备案信息
* @Author:strange
* @Date:13:01 2020-03-06
*/
@SeleniumDocument(
        domain = "http://app1.sfda.gov.cn/datasearchcnda/face3/dir.html",
        targetUrl = "国产医疗器械产品（备案）",
        cssQuery = "new_datafont1",
        partTitle = "械备",rollBackCss = "javascript:viewList()",
        pageNumberCss = "#content > div > table:nth-child(4) > tbody > tr > td",
        clazzName = "ChnRecord"
)
public class ChnRecord implements QueueTaskHandler {
    /** 国产备案表id  CHN_RECORD_ID **/
    private Integer chnRecordId;

    /** 备案号  CHN_RECORD_NUMBER **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(2) > td:nth-child(2)")
    private String chnRecordNumber;

    /** 备案人名称  RECORD_NAME **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(3) > td:nth-child(2)")
    private String recordName;

    /** 产品名称  GOODS_NAME **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(6) > td:nth-child(2)")
    private String goodsName;

    /** 备注  NOTE **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(10) > td:nth-child(2)")
    private String note;

    /** 备案单位	  RECORD_DEPA **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(11) > td:nth-child(2)")
    private String recordDepa;

    /** 备案日期  RECORD_DATE **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(12) > td:nth-child(2)")
    private String recordDate;

    /** 产品储存条件及有效期  EXPIRATION_STORAGE **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(14) > td:nth-child(2)")
    private String expiration;

    /** 备案人注册地址  RECORD_ADDRESS **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(4) > td:nth-child(2)")
    private String recordAddress;

    /** 生产地址  PRODUCT_ADDRESS **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(5) > td:nth-child(2)")
    private String productAddress;

    /** 型号规格  MODEL **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(7) > td:nth-child(2)")
    private String model;

    /** 产品描述  DESCRIPTION **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(8) > td:nth-child(2)")
    private String description;

    /** 预期用途  INTENDED **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(9) > td:nth-child(2)")
    private String intended;

    /** 变更情况  UPDATE_CONTENT **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(13) > td:nth-child(2)")
    private String updateContent;

    /**国产备案类型 **/
    private Integer optType = 1;

    /** 添加时间  ADD_TIME **/
    private Date addTime;

    /** 添加人  CREATOR **/
    private String creator="crawler";

    /** 修改时间  MODE_TIME **/
    private Date modeTime;

    /** 修改人  UPDATER **/
    private String updater="crawler";

    /** 是否删除  0否  1是  IS_DELETE **/
    private Integer isDelete=0;

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getModeTime() {
        return modeTime;
    }

    public void setModeTime(Date modeTime) {
        this.modeTime = modeTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getOptType() {
        return optType;
    }

    public void setOptType(Integer optType) {
        this.optType = optType;
    }

    /**   备案人注册地址  RECORD_ADDRESS   **/
    public String getRecordAddress() {
        return recordAddress;
    }

    /**   备案人注册地址  RECORD_ADDRESS   **/
    public void setRecordAddress(String recordAddress) {
        this.recordAddress = recordAddress == null ? null : recordAddress.trim();
    }

    /**   生产地址  PRODUCT_ADDRESS   **/
    public String getProductAddress() {
        return productAddress;
    }

    /**   生产地址  PRODUCT_ADDRESS   **/
    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress == null ? null : productAddress.trim();
    }

    /**   型号规格  MODEL   **/
    public String getModel() {
        return model;
    }

    /**   型号规格  MODEL   **/
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**   产品描述  DESCRIPTION   **/
    public String getDescription() {
        return description;
    }

    /**   产品描述  DESCRIPTION   **/
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**   预期用途  INTENDED   **/
    public String getIntended() {
        return intended;
    }

    /**   预期用途  INTENDED   **/
    public void setIntended(String intended) {
        this.intended = intended == null ? null : intended.trim();
    }

    /**   变更情况  UPDATE_CONTENT   **/
    public String getUpdateContent() {
        return updateContent;
    }

    /**   变更情况  UPDATE_CONTENT   **/
    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent == null ? null : updateContent.trim();
    }

    public Integer getChnRecordId() {
        return chnRecordId;
    }

    public void setChnRecordId(Integer chnRecordId) {
        this.chnRecordId = chnRecordId;
    }

    public String getChnRecordNumber() {
        return chnRecordNumber;
    }

    public void setChnRecordNumber(String chnRecordNumber) {
        this.chnRecordNumber = chnRecordNumber;
    }

    /**   备案人名称  RECORD_NAME   **/
    public String getRecordName() {
        return recordName;
    }

    /**   备案人名称  RECORD_NAME   **/
    public void setRecordName(String recordName) {
        this.recordName = recordName == null ? null : recordName.trim();
    }

    /**   产品名称  GOODS_NAME   **/
    public String getGoodsName() {
        return goodsName;
    }

    /**   产品名称  GOODS_NAME   **/
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**   备注  NOTE   **/
    public String getNote() {
        return note;
    }

    /**   备注  NOTE   **/
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**   备案单位	  RECORD_DEPA   **/
    public String getRecordDepa() {
        return recordDepa;
    }

    /**   备案单位	  RECORD_DEPA   **/
    public void setRecordDepa(String recordDepa) {
        this.recordDepa = recordDepa == null ? null : recordDepa.trim();
    }

    /**   备案日期  RECORD_DATE   **/
    public String getRecordDate() {
        return recordDate;
    }

    /**   备案日期  RECORD_DATE   **/
    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate == null ? null : recordDate.trim();
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @Override
    public void processData() {
        CrawlerService crawlerService = SpringUtils.getBean(CrawlerService.class);
        crawlerService.saveChnRecord(this);
    }
}