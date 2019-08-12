package org.item.jurisdiction.logs;

import java.util.Date;

public class SystemLog {
    private String id;
    private String description;
    private String method;
    private Long logType;
    private String requestIp;
    private String exceptioncode;
    private String exceptionDetail;
    private String params;
    private String createBy;
    private Date createDate;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = (id == null) ? null : id.trim();
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = (description == null) ? null : description.trim();
    }

    public String getMethod() {
        return this.method;
    }


    public void setMethod(String method) {
        this.method = (method == null) ? null : method.trim();
    }

    public Long getLogType() {
        return this.logType;
    }

    public void setLogType(Long logType) {
        this.logType = logType;
    }

    public String getRequestIp() {
        return this.requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = (requestIp == null) ? null : requestIp.trim();
    }

    public String getExceptioncode() {
        return this.exceptioncode;
    }


    public void setExceptioncode(String exceptioncode) {
        this.exceptioncode = (exceptioncode == null) ? null : exceptioncode.trim();
    }

    public String getExceptionDetail() {
        return this.exceptionDetail;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = (exceptionDetail == null) ? null : exceptionDetail.trim();
    }

    public String getParams() {
        return this.params;
    }

    public void setParams(String params) {
        this.params = (params == null) ? null : params.trim();
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = (createBy == null) ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
