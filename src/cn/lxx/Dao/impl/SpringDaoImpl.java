package cn.lxx.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.lxx.Dao.SpringDao;
import cn.lxx.entity.Student;

public class SpringDaoImpl implements SpringDao {

	@Override
	public boolean addStu(Student stu) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BasicDataSource basicDataSource = (BasicDataSource)context.getBean("dataSource");
		String sql = "INSERT INTO `springdemo`.`student` (`sno`, `sname`, `sage`) VALUES (?, ?, ?)";
		try {
			Connection con = basicDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, stu.getSno());
			ps.setString(2, stu.getSname());
			ps.setInt(3, stu.getSage());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
