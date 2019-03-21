package ch30.x;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
  
  @Before("execution(* ch30.f.X.*(..)) and args(p2, p3, p1)")
  public void doBefore(String p1, int p2, int p3) {
    System.out.printf("%s.doBefore()\n", this.getClass().getName());
    System.out.printf("  => %s %d %d\n", p1, p2, p3);
  }
  
  @After("execution(* ch30.f.X.*(..))")
  public void doAfter() {
    System.out.printf("%s.doAfter()\n", this.getClass().getName());
  }

  @AfterReturning(pointcut="execution(* ch30.f.X.*(..))", returning="rv")
  public void doAfterReturning(Object rv) {
    System.out.printf("%s.doAfterReturning()\n", this.getClass().getName());
    System.out.printf("  -> %d\n", rv);
  }

  @AfterThrowing(pointcut="execution(* ch30.f.X.*(..))", throwing="err")
  public void doAfterThrowing(Exception err) {
    System.out.printf("%s.doAfterThrowing()\n", this.getClass().getName());
    System.out.printf("  => %s\n", err.getMessage());
  }

}
