package com.vedeng.crawler.model;

import com.vedeng.crawler.common.annotation.Extract;
import com.vedeng.crawler.common.annotation.SeleniumDocument;
import com.vedeng.crawler.common.queue.QueueTaskHandler;
import com.vedeng.crawler.common.queue.SpringUtils;
import com.vedeng.crawler.service.crawler.CrawlerService;

import java.util.Date;

/**
*国产注册信息
* @Author:strange
* @Date:13:01 2020-03-06
*/
@SeleniumDocument(
        domain = "http://app1.sfda.gov.cn/datasearchcnda/face3/dir.html",
        targetUrl = "国产医疗器械产品（注册）",
        cssQuery = "new_datafont1",
        partTitle = "注准",rollBackCss = "javascript:viewList()",
        pageNumberCss = "#content > div > table:nth-child(4) > tbody > tr > td",
        clazzName = "ChnRegister"
)
public class ChnRegister implements QueueTaskHandler {

    /** 国产注册表id  CHN_REGISTER_ID **/
    private Integer chnRegisterId;

    /** 注册证编号  CHN_REGISTER_NUMBER **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(2) > td:nth-child(2)")
    private String chnRegisterNumber;

    /** 注册人名称  REGISTER_NAME **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(3) > td:nth-child(2)")
    private String registerName;

    /** 产品名称  GOODS_NAME **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(6) > td:nth-child(2)")
    private String goodsName;

    /** 管理类别  MANAGE_TYPE **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(7) > td:nth-child(2)")
    private String manageType;

    /** 产品储存条件及有效期  EXPIRATION_STORAGE **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(11) > td:nth-child(2)")
    private String expirationStorage;

    /** 附件  ATTACHMENT **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(12) > td:nth-child(2)")
    private String attachment;

    /** 其他内容  OTHER_CONTENT **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(13) > td:nth-child(2)")
    private String otherContent;

    /** 备注  NOTE **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(14) > td:nth-child(2)")
    private String note;

    /** 审批部门	  APPROVAL_DEPA **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(15) > td:nth-child(2)")
    private String approvalDepa;

    /** 批准日期  APPROVAL_DATE **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(16) > td:nth-child(2)")
    private String approvalDate;

    /** 有效期至  EXPIRATION_DATE **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(17) > td:nth-child(2)")
    private String expirationDate;

    /** 注册人住所  REGISTER_ADDRESS **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(4) > td:nth-child(2)")
    private String registerAddress;

    /** 生产地址  PRODUCT_ADDRESS **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(5) > td:nth-child(2)")
    private String productAddress;

    /** 型号规格  MODEL **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(8) > td:nth-child(2)")
    private String model;

    /** 结构及组成/主要组成成分  COMPOSITION **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(9) > td:nth-child(2)")
    private String composition;

    /** 适用范围/预期用途  SCOPE **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(10) > td:nth-child(2)")
    private String scope;

    /** 变更情况  UPDATE_CONTENT **/
    @Extract(cssQuery = "#content > div > div > table:nth-child(1) > tbody > tr:nth-child(18) > td:nth-child(2)")
    private String updateContent;

    /**国产注册类型 **/
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

    /**   国产注册表id  CHN_REGISTER_ID   **/
    public Integer getChnRegisterId() {
        return chnRegisterId;
    }

    /**   国产注册表id  CHN_REGISTER_ID   **/
    public void setChnRegisterId(Integer chnRegisterId) {
        this.chnRegisterId = chnRegisterId;
    }

    /**   注册证编号  CHN_REGISTER_NUMBER   **/
    public String getChnRegisterNumber() {
        return chnRegisterNumber;
    }

    /**   注册证编号  CHN_REGISTER_NUMBER   **/
    public void setChnRegisterNumber(String chnRegisterNumber) {
        this.chnRegisterNumber = chnRegisterNumber == null ? null : chnRegisterNumber.trim();
    }

    /**   注册人名称  REGISTER_NAME   **/
    public String getRegisterName() {
        return registerName;
    }

    /**   注册人名称  REGISTER_NAME   **/
    public void setRegisterName(String registerName) {
        this.registerName = registerName == null ? null : registerName.trim();
    }

    /**   产品名称  GOODS_NAME   **/
    public String getGoodsName() {
        return goodsName;
    }

    /**   产品名称  GOODS_NAME   **/
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**   管理类别  MANAGE_TYPE   **/
    public String getManageType() {
        return manageType;
    }

    /**   管理类别  MANAGE_TYPE   **/
    public void setManageType(String manageType) {
        this.manageType = manageType == null ? null : manageType.trim();
    }

    /**   产品储存条件及有效期  EXPIRATION_STORAGE   **/
    public String getExpirationStorage() {
        return expirationStorage;
    }

    /**   产品储存条件及有效期  EXPIRATION_STORAGE   **/
    public void setExpirationStorage(String expirationStorage) {
        this.expirationStorage = expirationStorage == null ? null : expirationStorage.trim();
    }

    /**   附件  ATTACHMENT   **/
    public String getAttachment() {
        return attachment;
    }

    /**   附件  ATTACHMENT   **/
    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    /**   其他内容  OTHER_CONTENT   **/
    public String getOtherContent() {
        return otherContent;
    }

    /**   其他内容  OTHER_CONTENT   **/
    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent == null ? null : otherContent.trim();
    }

    /**   备注  NOTE   **/
    public String getNote() {
        return note;
    }

    /**   备注  NOTE   **/
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**   审批部门	  APPROVAL_DEPA   **/
    public String getApprovalDepa() {
        return approvalDepa;
    }

    /**   审批部门	  APPROVAL_DEPA   **/
    public void setApprovalDepa(String approvalDepa) {
        this.approvalDepa = approvalDepa == null ? null : approvalDepa.trim();
    }

    /**   批准日期  APPROVAL_DATE   **/
    public String getApprovalDate() {
        return approvalDate;
    }

    /**   批准日期  APPROVAL_DATE   **/
    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate == null ? null : approvalDate.trim();
    }

    /**   有效期至  EXPIRATION_DATE   **/
    public String getExpirationDate() {
        return expirationDate;
    }

    /**   有效期至  EXPIRATION_DATE   **/
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate == null ? null : expirationDate.trim();
    }

    /**   注册人住所  REGISTER_ADDRESS   **/
    public String getRegisterAddress() {
        return registerAddress;
    }

    /**   注册人住所  REGISTER_ADDRESS   **/
    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress == null ? null : registerAddress.trim();
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

    /**   结构及组成/主要组成成分  COMPOSITION   **/
    public String getComposition() {
        return composition;
    }

    /**   结构及组成/主要组成成分  COMPOSITION   **/
    public void setComposition(String composition) {
        this.composition = composition == null ? null : composition.trim();
    }

    /**   适用范围/预期用途  SCOPE   **/
    public String getScope() {
        return scope;
    }

    /**   适用范围/预期用途  SCOPE   **/
    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    /**   变更情况  UPDATE_CONTENT   **/
    public String getUpdateContent() {
        return updateContent;
    }

    /**   变更情况  UPDATE_CONTENT   **/
    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent == null ? null : updateContent.trim();
    }

    @Override
    public String toString() {
        return "ChnRegister{" +
                "chnRegisterId=" + chnRegisterId +
                ", chnRegisterNumber='" + chnRegisterNumber + '\'' +
                ", registerName='" + registerName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", manageType='" + manageType + '\'' +
                ", expirationStorage='" + expirationStorage + '\'' +
                ", attachment='" + attachment + '\'' +
                ", otherContent='" + otherContent + '\'' +
                ", note='" + note + '\'' +
                ", approvalDepa='" + approvalDepa + '\'' +
                ", approvalDate='" + approvalDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", registerAddress='" + registerAddress + '\'' +
                ", productAddress='" + productAddress + '\'' +
                ", model='" + model + '\'' +
                ", composition='" + composition + '\'' +
                ", scope='" + scope + '\'' +
                ", updateContent='" + updateContent + '\'' +
                '}';
    }

    @Override
    public void processData() {
        CrawlerService bean = SpringUtils.getBean(CrawlerService.class);
        bean.saveChnRegister(this);
    }
}