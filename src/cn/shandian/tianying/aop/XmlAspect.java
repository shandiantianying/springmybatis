package cn.shandian.tianying.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class XmlAspect {

	public void doBefore(JoinPoint jp) {
		System.out.println("XML执行方法之前" + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	public void doAfter(JoinPoint jp) {
		System.out.println("XML执行方法之后" + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("XML进入方法---环绕通知");
		Object o = pjp.proceed();
		System.out.println("XML进入方法---环绕通知");
		return o;
	}

	public void doAfterReturning(Object retVal) {
		System.out.println("后置通知");
		System.out.println("---" + retVal + "---");
	}

	public void doThrow(Exception ex) {
		System.out.println("执行数据:" + ex.getMessage());
	}

}
