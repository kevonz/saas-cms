package com.yunkuo.cms.dao.main;

import com.yunkuo.cms.entity.main.CmsUserExt;
import com.yunkuo.common.hibernate3.Updater;

public interface CmsUserExtDao {
	public CmsUserExt findById(Integer id);

	public CmsUserExt save(CmsUserExt bean);

	public CmsUserExt updateByUpdater(Updater<CmsUserExt> updater);
}