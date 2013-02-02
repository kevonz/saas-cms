package com.yunkuo.cms.dao.main;

import com.yunkuo.cms.entity.main.ContentExt;
import com.yunkuo.common.hibernate3.Updater;

public interface ContentExtDao {
	public ContentExt findById(Integer id);

	public ContentExt save(ContentExt bean);

	public ContentExt updateByUpdater(Updater<ContentExt> updater);
}