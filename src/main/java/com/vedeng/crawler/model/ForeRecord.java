package com.vedeng.crawler.model;

import com.vedeng.crawler.common.annotation.Extract;
import com.vedeng.crawler.common.annotation.SeleniumDocument;
import com.vedeng.crawler.common.queue.QueueTaskHandler;
import com.vedeng.crawler.common.queue.SpringUtils;
import com.vedeng.crawler.service.crawler.CrawlerService;

import java.util.Date;

/**
*进口备案信息
* @Author:strange
* @Date:13:02 2020-03-06
*/
@SeleniumDocument(
//        domain = "http://app1.sfda.gov.cn/datasearchcnda/face3/dir.html",
        domain = "http://app1.sfda.gov.cn/datasearchcnda/face3/base.jsp?tableId=104&tableName=TABLE104&title=%E8%BF%9B%E5%8F%A3%E5%8C%BB%E7%96%97%E5%99%A8%E6%A2%B0%E4%BA%A7%E5%93%81%EF%BC%88%E5%A4%87%E6%A1%88%EF%BC%89&bcId=152904498781962056127955207188",
        targetUrl = "进口医疗器械产品（备案）",
        cssQuery = "new_datafont1",
        partTitle = "械备",rollBackCss = "javascript:viewList()",
        pageNumberCss = "#content > div > table:nth-child(4) > tbody > tr > td",
        clazzName = "ForeRecord"
)
public class ForeRecord implements QueueTaskHandler {
    /** 进口备案表id  FORE_RECORD_ID **/
    private Integer foreRecordId;

    /** 备案号  FORE_RECORD_NUMBER **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(2) > td:nth-child(2)")
    private String foreRecordNumber;

    /** 备案人名称  RECORD_NAME **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(3) > td:nth-child(2)")
    private String recordName;

    /** 产品名称  GOODS_NAME **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(8) > td:nth-child(2)")
    private String goodsName;

    /** 备注  NOTE **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(12) > td:nth-child(2)")
    private String note;

    /** 备案单位	  RECORD_DEPA **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(13) > td:nth-child(2)")
    private String recordDepa;

    /** 备案日期  RECORD_DATE **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(14) > td:nth-child(2)")
    private String recordDate;

    /** 产品有效期  EXPIRATION **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(15) > td:nth-child(2)")
    private String expiration;

    /** 备案人注册地址  RECORD_ADDRESS **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(4) > td:nth-child(2)")
    private String recordAddress;

    /** 生产地址  PRODUCT_ADDRESS **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(5) > td:nth-child(2)")
    private String productAddress;

    /** 代理人名称  PROXY_NAME **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(6) > td:nth-child(2)")
    private String proxyName;

    /** 代理人住所  PROXY_ADDRESS **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(7) > td:nth-child(2)")
    private String proxyAddress;

    /** 型号规格  MODEL **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(9) > td:nth-child(2)")
    private String model;

    /** 产品描述  DESCRIPTION **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(10) > td:nth-child(2)")
    private String description;

    /** 预期用途  INTENDED **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(11) > td:nth-child(2)")
    private String intended;

    /** 变更情况  UPDATE_CONTENT **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(16) > td:nth-child(2)")
    private String updateContent;

    /**国产备案类型 **/
    private Integer optType = 2;

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

    /**   代理人名称  PROXY_NAME   **/
    public String getProxyName() {
        return proxyName;
    }

    /**   代理人名称  PROXY_NAME   **/
    public void setProxyName(String proxyName) {
        this.proxyName = proxyName == null ? null : proxyName.trim();
    }

    /**   代理人住所  PROXY_ADDRESS   **/
    public String getProxyAddress() {
        return proxyAddress;
    }

    /**   代理人住所  PROXY_ADDRESS   **/
    public void setProxyAddress(String proxyAddress) {
        this.proxyAddress = proxyAddress == null ? null : proxyAddress.trim();
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

    /**   国产备案表id  FORE_RECORD_ID   **/
    public Integer getForeRecordId() {
        return foreRecordId;
    }

    /**   国产备案表id  FORE_RECORD_ID   **/
    public void setForeRecordId(Integer foreRecordId) {
        this.foreRecordId = foreRecordId;
    }

    /**   备案号  FORE_RECORD_NUMBER   **/
    public String getForeRecordNumber() {
        return foreRecordNumber;
    }

    /**   备案号  FORE_RECORD_NUMBER   **/
    public void setForeRecordNumber(String foreRecordNumber) {
        this.foreRecordNumber = foreRecordNumber == null ? null : foreRecordNumber.trim();
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

    /**   产品有效期  EXPIRATION   **/
    public String getExpiration() {
        return expiration;
    }

    /**   产品有效期  EXPIRATION   **/
    public void setExpiration(String expiration) {
        this.expiration = expiration == null ? null : expiration.trim();
    }

    @Override
    public void processData() {
        CrawlerService bean = SpringUtils.getBean(CrawlerService.class);
        bean.saveForeRecord(this);
    }
}