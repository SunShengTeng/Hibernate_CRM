package cn.sst.hibernate.Service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.sst.hibernate.entity.Customer;

public interface CustomerService {

	/**
	 * @param id
	 * @return
	 */
	public Customer searchCustomer(long id);
	
	/**
	 * @param c
	 */
	public void insertCustomer(Customer c);

	/**
	 * @param c
	 */
	public void updateCustomer(Customer c);
	
	/**
	 * @param c
	 */
	public void deleteCustomer(Customer c);
    
	/**
	 * 获取所有客户
	 * @return
	 */
	public List<Customer> getAllCustomer();

	/**
	 * 条件查询客户
	 * @param detachedCriteria
	 * @return
	 */
	public List<Customer> getAllCustomer(DetachedCriteria detachedCriteria);
	
}
