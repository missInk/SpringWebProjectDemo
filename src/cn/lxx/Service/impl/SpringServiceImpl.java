package cn.lxx.Service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.lxx.Dao.SpringDao;
import cn.lxx.Service.SpringService;
import cn.lxx.entity.Student;

public class SpringServiceImpl implements SpringService {

	@Override
	public boolean addStu() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student stu = (Student)context.getBean("Student");
		stu.setSage(12);
		stu.setSname("lxx");
		stu.setSno(1);
		SpringDao springDao = (SpringDao)context.getBean("springDao");
		boolean success = springDao.addStu(null);
		return success;
	}

}
