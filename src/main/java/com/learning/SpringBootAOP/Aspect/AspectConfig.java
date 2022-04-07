package com.learning.SpringBootAOP.Aspect;

import com.learning.SpringBootAOP.Entity.Country;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@Profile("notaspect")
public class AspectConfig {

  @Pointcut("execution(* com.learning.SpringBootAOP.Controller.*.*(..))&&args(id)")
  public void jointPoint(Long id){}

//  @Before("jointPoint()")
//  public void before(JoinPoint joinPoint){
//    log.info("Before advice: "+joinPoint.getArgs()[0]);
//  }
//
//  @AfterReturning(value = "jointPoint()", returning = "country")
//  public void after(JoinPoint joinPoint, Country country){
//    log.info("After advice::"+country.toString());
//  }
//
//  @AfterThrowing(value = "jointPoint()", throwing = "e")
//  public void after( Exception e){
//    log.info("After advice: "+e.getMessage());
//  }

  @Around(value = "jointPoint(id)")
  public Object around(ProceedingJoinPoint joinPoint, Long id) throws Throwable {
    log.info("Before advice::"+joinPoint.getSignature()+"With id"+id);

    Object object = joinPoint.proceed();

    if(object instanceof Country)
    log.info("After procced::"+object);

    return object;
  }

}
