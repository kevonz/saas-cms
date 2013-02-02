package com.yunkuo.cms.dao.main;

import com.yunkuo.cms.entity.main.ChannelExt;
import com.yunkuo.common.hibernate3.Updater;

public interface ChannelExtDao {
	public ChannelExt save(ChannelExt bean);

	public ChannelExt updateByUpdater(Updater<ChannelExt> updater);
}