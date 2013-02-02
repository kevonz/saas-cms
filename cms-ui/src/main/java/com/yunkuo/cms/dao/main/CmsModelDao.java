package com.yunkuo.cms.dao.main;

import java.util.List;

import com.yunkuo.cms.entity.main.CmsModel;
import com.yunkuo.common.hibernate3.Updater;

public interface CmsModelDao {
	public List<CmsModel> getList(boolean containDisabled);

	public CmsModel getDefModel();

	public CmsModel findById(Integer id);

	public CmsModel save(CmsModel bean);

	public CmsModel updateByUpdater(Updater<CmsModel> updater);

	public CmsModel deleteById(Integer id);
}