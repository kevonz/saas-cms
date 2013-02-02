package com.yunkuo.cms.dao.main;

import com.yunkuo.cms.entity.main.ContentTxt;
import com.yunkuo.common.hibernate3.Updater;

public interface ContentTxtDao {
	public ContentTxt findById(Integer id);

	public ContentTxt save(ContentTxt bean);

	public ContentTxt updateByUpdater(Updater<ContentTxt> updater);
}