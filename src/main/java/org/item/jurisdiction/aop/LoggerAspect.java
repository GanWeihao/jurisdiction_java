/*    */ package aop;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import org.aspectj.lang.JoinPoint;
/*    */ import org.aspectj.lang.annotation.After;
/*    */ import org.aspectj.lang.annotation.Aspect;
/*    */ import org.aspectj.lang.annotation.Before;
/*    */ import org.aspectj.lang.annotation.Pointcut;
/*    */ import org.springframework.core.annotation.Order;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Aspect
/*    */ @Order(1)
/*    */ @Component
/*    */ public class LoggerAspect
/*    */ {
/*    */   @Pointcut("execution(* org.item.jurisdiction.service.Impl.*..*(..))")
/*    */   public void point() {}
/*    */   
/*    */   @Before("point()")
/*    */   public void beforMethod(JoinPoint joinPoint) {
/* 30 */     String methodName = joinPoint.getSignature().getName();
/* 31 */     List<Object> args = Arrays.asList(joinPoint.getArgs());
/* 32 */     System.out.println("this method " + methodName + " begin. param<" + args + ">");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @After("point()")
/*    */   public void afterMethod(JoinPoint joinPoint) {
/* 40 */     String methodName = joinPoint.getSignature().getName();
/* 41 */     System.out.println("this method " + methodName + " end.");
/*    */   }
/*    */ }
