package cn.sst.hibernate.Dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.sst.hibernate.entity.Customer;

public interface CustomerDao {
   /**
    * 根据ID查询客户
 * @param id
 * @return
 */
public Customer searchCustomer(Long id);

/**
 * 插入客户
 * @param c 客户
 */
public void insertCustomer(Customer c);

/**
 * 更新客户信息
 * @param c 客户
 */
public void updateCustomer(Customer c);
   
   /**
    * 删除客户
 * @param c 客户
 */
public void deleteCustomer(Customer c);
   
/**
 * 根据ID查询客户信息
 * @param id
 * @return
 */
public Customer getCustomerById(Long id);

public List<Customer> getAllCustomer();

/**
 * 条件查询所有客户
 * @param detachedCriteria
 * @return 
 */
public List<Customer> getAllCustomer(DetachedCriteria detachedCriteria);
}
