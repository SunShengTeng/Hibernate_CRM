package cn.sst.hibernateTest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.sst.hibernate.entity.Customer;
import cn.sst.hibernate.entity.LinkMan;
import cn.sst.hibernate.utils.HibernateUtils;

public class OneToManyTest {
    
	public void test(){
	 Session session = HibernateUtils.getCurrentSession();
	 Transaction transaction = session.beginTransaction();
	 
	 Customer customer = new Customer();
	 customer.setCust_name("极牛");
	 
	 LinkMan linkMan = new LinkMan();
	 linkMan.setLkm_name("联系人1");
//	 
//	 LinkMan linkMan2 = new LinkMan();
//	 linkMan2.setLkm_name("人事老油条");
	 
//	 customer.getLinkMans().add(linkMan);

	 linkMan.setCustomer(customer);

	 session.save(linkMan);
	 
	 transaction.commit();
	 
	}
    
    /**
     * 测试级联保存/更新
     */
    
	public void testCascade(){
	 Session session = HibernateUtils.getCurrentSession();
	 Transaction transaction = session.beginTransaction();
	 
	 Customer customer = new Customer();
	 customer.setCust_name("天天悦动");
	 
	 LinkMan linkMan = new LinkMan();
	 linkMan.setLkm_name("CEO吴际超");
	 
	 LinkMan linkMan2 = new LinkMan();
	 linkMan2.setLkm_name("HR燕燕");
	 
	 customer.getLinkMans().add(linkMan);
	 customer.getLinkMans().add(linkMan2);

	 
	 session.save(customer);
//	 session.save(linkMan);
//	 session.save(linkMan2);
	 
	 
	 transaction.commit();
	 
	}
    
    /**
     * Criteria测试级联删除
     */
    
    public void testCascadeDelete(){
    	Session session = HibernateUtils.getCurrentSession();
    	Transaction transaction = session.beginTransaction();
    	
    	Criteria criteria = session.createCriteria(Customer.class);
    	criteria.add(Restrictions.eq("cust_id", 1l));
    	
    	Customer customer = (Customer) criteria.uniqueResult();
    	session.delete(customer);
    	
    	transaction.commit();
    }
}

