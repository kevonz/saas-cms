package com.yunkuo.cms.dao.main;

import com.yunkuo.cms.entity.main.ContentCheck;
import com.yunkuo.common.hibernate3.Updater;

public interface ContentCheckDao {
	public ContentCheck findById(Long id);

	public ContentCheck save(ContentCheck bean);

	public ContentCheck updateByUpdater(Updater<ContentCheck> updater);
}