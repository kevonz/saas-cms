package com.yunkuo.cms.dao.assist;

import com.yunkuo.cms.entity.assist.CmsVoteItem;
import com.yunkuo.common.hibernate3.Updater;
import com.yunkuo.common.page.Pagination;

public interface CmsVoteItemDao {
	public Pagination getPage(int pageNo, int pageSize);

	public CmsVoteItem findById(Integer id);

	public CmsVoteItem save(CmsVoteItem bean);

	public CmsVoteItem updateByUpdater(Updater<CmsVoteItem> updater);

	public CmsVoteItem deleteById(Integer id);
}