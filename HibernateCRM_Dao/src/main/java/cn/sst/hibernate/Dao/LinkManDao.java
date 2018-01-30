package cn.sst.hibernate.Dao;

import java.util.List;

import cn.sst.hibernate.entity.LinkMan;

public interface LinkManDao {
  /**
 * 插入联系人
 */
public void insertLinkMan(LinkMan lkm);
/**
 * 查询所有的联系人
 * @return
 */
public List<LinkMan> findAllLinkMan();

}
