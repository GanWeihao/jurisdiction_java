/*    */ package org.item.jurisdiction.controller;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.UUID;
/*    */ import org.item.jurisdiction.util.JsonResult;
/*    */ import org.springframework.web.bind.annotation.CrossOrigin;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMethod;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @CrossOrigin
/*    */ @RestController
/*    */ public class FileController
/*    */ {
/*    */   @RequestMapping(value = {"/file/upload"}, method = {RequestMethod.POST})
/*    */   public JsonResult fileUpload2(@RequestParam("userHeadimg") MultipartFile file) throws IOException {
                JsonResult js;
/* 24 */     if (file.isEmpty()) {
/* 25 */       return new JsonResult("404", "上传失败，未选择文件！");
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 30 */       String fileName = file.getOriginalFilename();
/*    */       
/* 32 */       String suffixName = fileName.substring(fileName.lastIndexOf("."));
/*    */       
/* 34 */       String uuid = UUID.randomUUID().toString().replace("-", "");
/*    */       
/* 36 */       String newFilename = uuid + suffixName;
/*    */       
/* 38 */       String path = "C:\\image\\";
/*    */       
/* 40 */       File newFile = new File(path + newFilename);
/* 41 */       file.transferTo(newFile);
/* 42 */       js = new JsonResult("200", "上传成功", newFilename);
/*    */     }
/* 44 */     catch (Exception e) {
/* 45 */       e.printStackTrace();
/* 46 */       js = new JsonResult("500", "上传异常");
/*    */     } 
/*    */     
/* 49 */     return js;
/*    */   }
/*    */ }