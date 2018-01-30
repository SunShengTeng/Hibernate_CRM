package cn.sst.hibernateTest;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import cn.sst.hibernate.entity.Role;
import cn.sst.hibernate.entity.User;
import cn.sst.hibernate.utils.HibernateUtils;

public class ManyToMany {

	
	public void testSave(){
		
		
		try {
			HibernateUtils.getCurrentSession().beginTransaction();
			User user = new User();
			user.setUser_name("小李子");
			
			User user2 = new User();
			user2.setUser_name("二麻子");
			
			Role role = new Role();
			role.setRole_name("超级管理员");
			
			Role role2 = new Role();
			role2.setRole_name("运营人员");
			
	        user.getRoles().add(role);
	        user.getRoles().add(role2);
	        user2.getRoles().add(role);
	        user2.getRoles().add(role2);
						
	        role.getUsers().add(user);
	        role.getUsers().add(user2);
	        role2.getUsers().add(user);
	        role2.getUsers().add(user2);
	        
	        HibernateUtils.getCurrentSession().save(user);
	        HibernateUtils.getCurrentSession().save(user2);
			HibernateUtils.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			HibernateUtils.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
	public void testUpdate(){
		
		
	}
	
	/**
	 * 测试删除角色
	 * 
	 */
	
	public void testDelete(){
		try {
			HibernateUtils.getCurrentSession().beginTransaction();
			
			Role role = HibernateUtils.getCurrentSession().get(Role.class, 2l);
			HibernateUtils.getCurrentSession().delete(role);
			
			HibernateUtils.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			HibernateUtils.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		
		
		
	}
	
	public void testFind(){
		
		
	}
}
