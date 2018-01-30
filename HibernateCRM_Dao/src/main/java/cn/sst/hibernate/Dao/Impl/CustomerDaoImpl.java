package cn.sst.hibernate.Dao.Impl;

import java.util.List;

import org.apache.xml.resolver.apps.resolver;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.sst.hibernate.Dao.CustomerDao;
import cn.sst.hibernate.entity.Customer;
import cn.sst.hibernate.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	private Customer customer = null;
	private Criteria executableCriteria;

	@Override
	public Customer searchCustomer(Long id) {
		
		try {
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			customer = session.get(Customer.class, id);
		
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public void insertCustomer(Customer c) {
		Session session = HibernateUtils.getCurrentSession();
		
		session.save(c);
	
	}

	@Override
	public void updateCustomer(Customer c) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.get(Customer.class, c);
		
		tx.commit();
		session.close();

	}

	@Override
	public void deleteCustomer(Customer c) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.delete(c);
		
		tx.commit();
		session.close();	


	}
	
	public Customer getCustomerById(Long id){
		
		
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction tx = session.beginTransaction();
			
			customer = session.get(Customer.class, id);
			
			tx.commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
	
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		Session session = HibernateUtils.getCurrentSession();		
		Query query = session.createQuery("from Customer");
		
		return query.list();
		
	}

	
	@Override
	public List<Customer> getAllCustomer(DetachedCriteria detachedCriteria) {
		Session session = HibernateUtils.getCurrentSession();
		executableCriteria = detachedCriteria.getExecutableCriteria(session);
		return (List<Customer>)executableCriteria.list();
	}
}
