package cn.shandian.tianying.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.shandian.tianying.User.Article;
import cn.shandian.tianying.User.User;
import cn.shandian.tianying.aop.Service;
import cn.shandian.tianying.aop.ServiceB;
import cn.shandian.tianying.inter.IUser;

public class AopTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IUser mapper = (IUser) ctx.getBean("userMapper");
		// 测试id=1的用户查询，根据数据库中的情况，可以改成你自己的.
		User user = mapper.selectUserByID(2);
  
//		User uer =(User)ctx.getBean("user");
//		uer.setUserAge(30);
//		uer.setUserName("狗狗");
//		uer.setUserAddress("在风头中吹冷风");
//		
//		mapper.addUser(uer);
//		
		List<Article> articles = mapper.getUserArticles(1);
		
		for(Article article:articles){
			User ur = article.getUser();
			System.out.println(article.getTitle()+"----"+article.getContent()+"----"+ur.getUserName()+"-----"+ur.getUserAddress());
		}
		
//		List<User> users = mapper.selectUsers("狗狗");
//
//		for (User us : users) {
//			System.out.println(us.getUserAge() + "-------" + us.getUserName() + "-----" + us.getUserAddress());
//		}
	}

}
