package com.yunkuo.core.dao;

import java.util.List;

import com.yunkuo.common.hibernate3.Updater;
import com.yunkuo.common.page.Pagination;
import com.yunkuo.core.entity.UnifiedUser;

public interface UnifiedUserDao {
	public UnifiedUser getByUsername(String username);

	public List<UnifiedUser> getByEmail(String email);

	public int countByEmail(String email);

	public Pagination getPage(int pageNo, int pageSize);

	public UnifiedUser findById(Integer id);

	public UnifiedUser save(UnifiedUser bean);

	public UnifiedUser updateByUpdater(Updater<UnifiedUser> updater);

	public UnifiedUser deleteById(Integer id);
}