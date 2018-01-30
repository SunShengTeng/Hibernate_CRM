package cn.sst.hibernate.Service;

import java.util.List;

import cn.sst.hibernate.entity.LinkMan;

public interface LinkManService {
   /**
 * 插入联系人
 */
public void insertData(LinkMan lkm);
/**
 * 获取所有联系人
 * @return
 */
public List<LinkMan> findAllLinkMan();
}
