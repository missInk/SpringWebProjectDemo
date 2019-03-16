package cn.lxx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import cn.lxx.Service.SpringService;
import cn.lxx.entity.Student;

@Transactional
public class Test {
	
	@Transactional
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringService service = (SpringService)context.getBean("springService");
		boolean add = service.addStu();
		System.out.println(add);
	}
	
}
