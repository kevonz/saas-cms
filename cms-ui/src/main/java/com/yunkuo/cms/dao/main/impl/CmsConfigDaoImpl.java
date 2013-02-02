package com.yunkuo.cms.dao.main.impl;

import org.springframework.stereotype.Repository;

import com.yunkuo.cms.dao.main.CmsConfigDao;
import com.yunkuo.cms.entity.main.CmsConfig;
import com.yunkuo.common.hibernate3.HibernateBaseDao;

@Repository
public class CmsConfigDaoImpl extends HibernateBaseDao<CmsConfig, Integer>
		implements CmsConfigDao {
	public CmsConfig findById(Integer id) {
		CmsConfig entity = get(id);
		return entity;
	}

	@Override
	protected Class<CmsConfig> getEntityClass() {
		return CmsConfig.class;
	}
}