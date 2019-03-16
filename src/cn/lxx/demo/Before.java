package cn.lxx.demo;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component("Advice")
@Aspect
public class Before{

	@Pointcut("execution(public boolean cn.lxx.Dao.impl.SpringDaoImpl.addStu(cn.lxx.entity.Student))")
	private void afert() {}
	
	/*@AfterReturning(pointcut="execution(public boolean cn.lxx.Dao.impl.SpringDaoImpl.addStu(cn.lxx.entity.Student))",returning="returnning")*/
	@AfterReturning(pointcut="afert()",returning="returnning")
	public void afterReturning(JoinPoint jp,Object returnning){
		System.out.println("��ȡĿ�����"+jp.getTarget()+"����ȡ��������"+jp.getSignature().getName()+"����ȡ�����б�"+Arrays.toString(jp.getArgs()));
		System.out.println("���Ϊ��"+returnning);
	}
	
	@AfterThrowing(pointcut="afert()",throwing="e")
	public void afterThrowel(JoinPoint jp, NullPointerException e) {
		System.out.println("���ֿ�ָ���쳣");
	}
	
	@Around("afert()")
	public Object around(ProceedingJoinPoint jp) {
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
