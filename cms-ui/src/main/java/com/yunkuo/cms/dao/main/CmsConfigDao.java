package com.yunkuo.cms.dao.main;

import com.yunkuo.cms.entity.main.CmsConfig;
import com.yunkuo.common.hibernate3.Updater;

public interface CmsConfigDao {
	public CmsConfig findById(Integer id);

	public CmsConfig updateByUpdater(Updater<CmsConfig> updater);
}