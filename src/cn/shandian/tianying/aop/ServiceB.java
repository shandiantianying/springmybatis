package cn.shandian.tianying.aop;

import org.springframework.stereotype.Component;

@Component("serviceB")
public class ServiceB implements Service {

	@Override
	public void foo(String msg) {
		System.out.println("ServiceB:" + msg);

	}

}
