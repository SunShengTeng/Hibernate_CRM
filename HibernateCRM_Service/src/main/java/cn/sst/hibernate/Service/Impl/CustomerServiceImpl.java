package cn.sst.hibernate.Service.Impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.sst.hibernate.Dao.CustomerDao;
import cn.sst.hibernate.Dao.Impl.CustomerDaoImpl;
import cn.sst.hibernate.Service.CustomerService;
import cn.sst.hibernate.entity.Customer;
import cn.sst.hibernate.utils.HibernateUtils;


public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = new CustomerDaoImpl();
	
	@Override
	public Customer searchCustomer(long id) {
		
		return customerDao.searchCustomer(id);
	}

	@Override
	public void insertCustomer(Customer c) {
		
		try {
			HibernateUtils.getCurrentSession().beginTransaction();
			this.customerDao.insertCustomer(c);
			HibernateUtils.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			HibernateUtils.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	} 

	@Override
	public void updateCustomer(Customer c) {
		
		this.customerDao.updateCustomer(c);
	}

	@Override
	public void deleteCustomer(Customer c) {
		this.customerDao.deleteCustomer(c);
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = customerDao.getAllCustomer();
		
		tx.commit();
		
		
		return list;
	}

	@Override
	public List<Customer> getAllCustomer(DetachedCriteria detachedCriteria) {
		List<Customer> list = null;
		try {
			HibernateUtils.getCurrentSession().beginTransaction();
			list = customerDao.getAllCustomer(detachedCriteria);
			
			HibernateUtils.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			HibernateUtils.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		
		
		return list;
		
	}

}
