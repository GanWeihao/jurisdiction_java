/*     */ package org.item.jurisdiction.logs;
/*     */ 
/*     */ import java.util.Date;
/*     */ import org.item.jurisdiction.logs.SystemLog;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SystemLog
/*     */ {
/*     */   private String id;
/*     */   private String description;
/*     */   private String method;
/*     */   private Long logType;
/*     */   private String requestIp;
/*     */   private String exceptioncode;
/*     */   private String exceptionDetail;
/*     */   private String params;
/*     */   private String createBy;
/*     */   private Date createDate;
/*     */   
/*  27 */   public String getId() { return this.id; }
/*     */ 
/*     */ 
/*     */   
/*  31 */   public void setId(String id) { this.id = (id == null) ? null : id.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  35 */   public String getDescription() { return this.description; }
/*     */ 
/*     */ 
/*     */   
/*  39 */   public void setDescription(String description) { this.description = (description == null) ? null : description.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  43 */   public String getMethod() { return this.method; }
/*     */ 
/*     */ 
/*     */   
/*  47 */   public void setMethod(String method) { this.method = (method == null) ? null : method.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  51 */   public Long getLogType() { return this.logType; }
/*     */ 
/*     */ 
/*     */   
/*  55 */   public void setLogType(Long logType) { this.logType = logType; }
/*     */ 
/*     */ 
/*     */   
/*  59 */   public String getRequestIp() { return this.requestIp; }
/*     */ 
/*     */ 
/*     */   
/*  63 */   public void setRequestIp(String requestIp) { this.requestIp = (requestIp == null) ? null : requestIp.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  67 */   public String getExceptioncode() { return this.exceptioncode; }
/*     */ 
/*     */ 
/*     */   
/*  71 */   public void setExceptioncode(String exceptioncode) { this.exceptioncode = (exceptioncode == null) ? null : exceptioncode.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  75 */   public String getExceptionDetail() { return this.exceptionDetail; }
/*     */ 
/*     */ 
/*     */   
/*  79 */   public void setExceptionDetail(String exceptionDetail) { this.exceptionDetail = (exceptionDetail == null) ? null : exceptionDetail.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  83 */   public String getParams() { return this.params; }
/*     */ 
/*     */ 
/*     */   
/*  87 */   public void setParams(String params) { this.params = (params == null) ? null : params.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  91 */   public String getCreateBy() { return this.createBy; }
/*     */ 
/*     */ 
/*     */   
/*  95 */   public void setCreateBy(String createBy) { this.createBy = (createBy == null) ? null : createBy.trim(); }
/*     */ 
/*     */ 
/*     */   
/*  99 */   public Date getCreateDate() { return this.createDate; }
/*     */ 
/*     */ 
/*     */   
/* 103 */   public void setCreateDate(Date createDate) { this.createDate = createDate; }
/*     */ }
