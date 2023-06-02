package com.springlab.di_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("user")
public class TVUser {
	
//	private SamsungTV tv;
//	private LgTV tv;
	@Autowired
	@Qualifier("samsung2")
	private TV tv;
		
	public void setTv(TV tv) {
		this.tv = tv;
	}

	public TV getTv() {
		return tv;
	}

	public TVUser() {
//		tv = new SamsungTV();
//		tv = new LgTV2();
	}
	
	public TVUser(TV tv) {
		this.tv = tv;
	}
	
	public void watchTV() {
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
//		tv.turnOn();
//		tv.soundUp();
//		tv.soundDown();
//		tv.turnOff();
	}

	public static void main(String[] args) {

//		TV tv = (new TVBeanFactory()).getBean(args[0]);
		
		ApplicationContext context =
//			new ClassPathXmlApplicationContext("classpath:appContextConfig.xml");
			new AnnotationConfigApplicationContext(
				com.springlab.di_test.AppConfig.class);
		
//		TV tv = (TV) context.getBean("lg");		
//		TVUser user = new TVUser(tv);
		
		TVUser user = (TVUser)context.getBean("user");
		System.out.println("TV Model: " + user.getTv());
		user.watchTV();
		
	}

}
