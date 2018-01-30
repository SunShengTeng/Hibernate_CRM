package cn.sst.hibernate.Service.Impl;


import java.util.List;

import cn.sst.hibernate.Dao.CustomerDao;
import cn.sst.hibernate.Dao.LinkManDao;
import cn.sst.hibernate.Dao.Impl.CustomerDaoImpl;
import cn.sst.hibernate.Dao.Impl.LinkManDaoImpl;
import cn.sst.hibernate.Service.LinkManService;
import cn.sst.hibernate.entity.Customer;
import cn.sst.hibernate.entity.LinkMan;
import cn.sst.hibernate.utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {
    private CustomerDao CustomerDao = new CustomerDaoImpl();
	private LinkManDao linkManDao =  new LinkManDaoImpl();
	@Override
	public void insertData(LinkMan lkm) {
		try {
			HibernateUtils.getCurrentSession().beginTransaction();
			Customer customer = CustomerDao.searchCustomer(lkm.getCust_id());
			lkm.setCustomer(customer);
		    linkManDao.insertLinkMan(lkm);
			HibernateUtils.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			
			HibernateUtils.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public List<LinkMan> findAllLinkMan() {
		List<LinkMan> list = null;
		try {
			HibernateUtils.getCurrentSession().beginTransaction();
			list = linkManDao.findAllLinkMan();
			HibernateUtils.getCurrentSession().getTransaction().commit();
		} catch (Exception e) {
			HibernateUtils.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		
		return list;
	}
    
    
	

}
