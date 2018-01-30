package cn.sst.hibernateUtilTest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.sst.hibernate.entity.Customer;
import cn.sst.hibernate.utils.HibernateUtils;

public class CacheTest {

	@Test
	public void testDeme(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 2l);
		System.out.println(">>>>>>"+customer);
		Customer customer2 = session.get(Customer.class, 2l);
	    System.out.println("<<<<<<"+customer2);
		
		System.out.println(customer == customer2);
		
		
		tx.commit();
		session.close();
	}
}
