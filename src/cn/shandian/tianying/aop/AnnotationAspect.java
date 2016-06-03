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
		System.out.println("ִ�з���֮ǰ" + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	@After("pointCutMethod()")
	public void doAfter(JoinPoint jp) {
		System.out.println("ִ�з���֮��" + jp.getTarget().getClass().getName());
	}

	@AfterReturning(pointcut = "pointCutMethod()", returning = "result")
	public void doAfterReturning(String result) {
		System.out.println("ִ�з�����ϢdoAfterReturning:" + result);
	}

	@Around("pointCutMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("���뷽��---����֪ͨ");
		Object o = pjp.proceed();
		System.out.println("�˳�����---����֪ͨ");
		return o;
	}

	@AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
	public void afterThrowing(Exception e) {
		System.out.println("ִ�г�����־..");
		System.out.println(e.getMessage());
	}

}
