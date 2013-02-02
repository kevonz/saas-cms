package com.yunkuo.cms.dao.main;

import com.yunkuo.cms.entity.main.ChannelTxt;
import com.yunkuo.common.hibernate3.Updater;

public interface ChannelTxtDao {
	public ChannelTxt findById(Integer id);

	public ChannelTxt save(ChannelTxt bean);

	public ChannelTxt updateByUpdater(Updater<ChannelTxt> updater);
}