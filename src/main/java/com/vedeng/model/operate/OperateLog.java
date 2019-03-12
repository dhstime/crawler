package com.vedeng.model.operate;

public class OperateLog {
    /** 操作日志ID  OPERATE_LOG_ID **/
    private Integer operateLogId;

    /** 操作名称  OPERATE_LOG_NAME **/
    private String operateLogName;

    /** 操作模块ID  OPERATE_MODEL_ID **/
    private Integer operateModelId;

    /** 操作模块名称  OPERATE_MODEL_NAME **/
    private String operateModelName;

    /** 操作类型：1-新增/2-修改/3-删除/4-查询/5-下载导出/6-上传/7-执行  OPERATE_LOG_TYPE **/
    private Boolean operateLogType;

    /** 访问ip  ACCESS_IP **/
    private String accessIp;

    /** 访问时间  ACCESS_TIME **/
    private Long accessTime;

    /** 访问端UA  ACCESS_UA **/
    private String accessUa;

    /** 操作人USER_ID  OPERATE_USER_ID **/
    private Integer operateUserId;

    /** 操作人USER_NAME  OPERATE_USER_NAME **/
    private String operateUserName;

    /** 操作结果: 0 成功/-1 失败/其他异常  OPERATE_RESULT **/
    private Boolean operateResult;

    /** 操作参数  OPERATE_PARAMS **/
    private String operateParams;

    /**   操作日志ID  OPERATE_LOG_ID   **/
    public Integer getOperateLogId() {
        return operateLogId;
    }

    /**   操作日志ID  OPERATE_LOG_ID   **/
    public void setOperateLogId(Integer operateLogId) {
        this.operateLogId = operateLogId;
    }

    /**   操作名称  OPERATE_LOG_NAME   **/
    public String getOperateLogName() {
        return operateLogName;
    }

    /**   操作名称  OPERATE_LOG_NAME   **/
    public void setOperateLogName(String operateLogName) {
        this.operateLogName = operateLogName == null ? null : operateLogName.trim();
    }

    /**   操作模块ID  OPERATE_MODEL_ID   **/
    public Integer getOperateModelId() {
        return operateModelId;
    }

    /**   操作模块ID  OPERATE_MODEL_ID   **/
    public void setOperateModelId(Integer operateModelId) {
        this.operateModelId = operateModelId;
    }

    /**   操作模块名称  OPERATE_MODEL_NAME   **/
    public String getOperateModelName() {
        return operateModelName;
    }

    /**   操作模块名称  OPERATE_MODEL_NAME   **/
    public void setOperateModelName(String operateModelName) {
        this.operateModelName = operateModelName == null ? null : operateModelName.trim();
    }

    /**   操作类型：1-新增/2-修改/3-删除/4-查询/5-下载导出/6-上传/7-执行  OPERATE_LOG_TYPE   **/
    public Boolean getOperateLogType() {
        return operateLogType;
    }

    /**   操作类型：1-新增/2-修改/3-删除/4-查询/5-下载导出/6-上传/7-执行  OPERATE_LOG_TYPE   **/
    public void setOperateLogType(Boolean operateLogType) {
        this.operateLogType = operateLogType;
    }

    /**   访问ip  ACCESS_IP   **/
    public String getAccessIp() {
        return accessIp;
    }

    /**   访问ip  ACCESS_IP   **/
    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp == null ? null : accessIp.trim();
    }

    /**   访问时间  ACCESS_TIME   **/
    public Long getAccessTime() {
        return accessTime;
    }

    /**   访问时间  ACCESS_TIME   **/
    public void setAccessTime(Long accessTime) {
        this.accessTime = accessTime;
    }

    /**   访问端UA  ACCESS_UA   **/
    public String getAccessUa() {
        return accessUa;
    }

    /**   访问端UA  ACCESS_UA   **/
    public void setAccessUa(String accessUa) {
        this.accessUa = accessUa == null ? null : accessUa.trim();
    }

    /**   操作人USER_ID  OPERATE_USER_ID   **/
    public Integer getOperateUserId() {
        return operateUserId;
    }

    /**   操作人USER_ID  OPERATE_USER_ID   **/
    public void setOperateUserId(Integer operateUserId) {
        this.operateUserId = operateUserId;
    }

    /**   操作人USER_NAME  OPERATE_USER_NAME   **/
    public String getOperateUserName() {
        return operateUserName;
    }

    /**   操作人USER_NAME  OPERATE_USER_NAME   **/
    public void setOperateUserName(String operateUserName) {
        this.operateUserName = operateUserName == null ? null : operateUserName.trim();
    }

    /**   操作结果: 0 成功/-1 失败/其他异常  OPERATE_RESULT   **/
    public Boolean getOperateResult() {
        return operateResult;
    }

    /**   操作结果: 0 成功/-1 失败/其他异常  OPERATE_RESULT   **/
    public void setOperateResult(Boolean operateResult) {
        this.operateResult = operateResult;
    }

    /**   操作参数  OPERATE_PARAMS   **/
    public String getOperateParams() {
        return operateParams;
    }

    /**   操作参数  OPERATE_PARAMS   **/
    public void setOperateParams(String operateParams) {
        this.operateParams = operateParams == null ? null : operateParams.trim();
    }
}