package cn.sst.hibernate.Dao.Impl;

import java.util.List;

import org.hibernate.Criteria;

import cn.sst.hibernate.Dao.LinkManDao;
import cn.sst.hibernate.entity.LinkMan;
import cn.sst.hibernate.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	@Override
	public void insertLinkMan(LinkMan lkm) {
		HibernateUtils.getCurrentSession().save(lkm);
		
	}

	@Override
	public List<LinkMan> findAllLinkMan() {
		return HibernateUtils.getCurrentSession().createCriteria(LinkMan.class).list();
	}

	
  
}
