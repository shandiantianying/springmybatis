package cn.shandian.tianying.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class XmlAspect {

	public void doBefore(JoinPoint jp) {
		System.out.println("XMLִ�з���֮ǰ" + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	public void doAfter(JoinPoint jp) {
		System.out.println("XMLִ�з���֮��" + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());
	}

	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("XML���뷽��---����֪ͨ");
		Object o = pjp.proceed();
		System.out.println("XML���뷽��---����֪ͨ");
		return o;
	}

	public void doAfterReturning(Object retVal) {
		System.out.println("����֪ͨ");
		System.out.println("---" + retVal + "---");
	}

	public void doThrow(Exception ex) {
		System.out.println("ִ������:" + ex.getMessage());
	}

}
