package com.yunkuo.cms.manager.main;

import com.yunkuo.cms.entity.main.Channel;
import com.yunkuo.cms.entity.main.ChannelExt;

public interface ChannelExtMng {
	public ChannelExt save(ChannelExt ext, Channel channel);

	public ChannelExt update(ChannelExt ext);
}