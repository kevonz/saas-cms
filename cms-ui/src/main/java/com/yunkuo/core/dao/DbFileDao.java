package com.yunkuo.core.dao;

import com.yunkuo.common.hibernate3.Updater;
import com.yunkuo.core.entity.DbFile;

public interface DbFileDao {
	public DbFile findById(String id);

	public DbFile save(DbFile bean);

	public DbFile updateByUpdater(Updater<DbFile> updater);

	public DbFile deleteById(String id);
}