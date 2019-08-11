/*    */ package org.item.jurisdiction.util;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StringUtil
/*    */ {
/*    */   public static Object isnull(Object obj) {
/*  9 */     if (obj != null) {
/* 10 */       return obj;
/*    */     }
/* 12 */     return "";
/*    */   }
/*    */   
/*    */   public static Object iszore(Object obj) {
/* 16 */     if (obj != null) {
/* 17 */       return obj;
/*    */     }
/* 19 */     return Integer.valueOf(0);
/*    */   }
/*    */ }