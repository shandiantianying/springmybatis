package cn.shandian.tianying.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component("annotationApect")
public class AnnotationAspect {
	@Pointcut("execution(* cn.shandian.tianying.aop.*.*(..))")
	public void pointCutMethod() {
	}

	@Before("pointCutMethod()")
	public void doBefore(JoinPoint jp) {
		System.out.println("执行方法之前" + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	@After("pointCutMethod()")
	public void doAfter(JoinPoint jp) {
		System.out.println("执行方法之后" + jp.getTarget().getClass().getName());
	}

	@AfterReturning(pointcut = "pointCutMethod()", returning = "result")
	public void doAfterReturning(String result) {
		System.out.println("执行返回消息doAfterReturning:" + result);
	}

	@Around("pointCutMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("进入方法---环绕通知");
		Object o = pjp.proceed();
		System.out.println("退出方法---环绕通知");
		return o;
	}

	@AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
	public void afterThrowing(Exception e) {
		System.out.println("执行出错日志..");
		System.out.println(e.getMessage());
	}

}
