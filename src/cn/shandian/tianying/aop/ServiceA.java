package cn.shandian.tianying.aop;

import org.springframework.stereotype.Component;

@Component("serviceA")
public class ServiceA implements Service {

	@Override
	public void foo(String msg) {
		System.out.println("ServiceA:" + msg);
	}

}
