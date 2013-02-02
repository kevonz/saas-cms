package com.yunkuo.cms.manager.main;

import com.yunkuo.cms.entity.main.Content;
import com.yunkuo.cms.entity.main.ContentExt;

public interface ContentExtMng {
	public ContentExt save(ContentExt ext, Content content);

	public ContentExt update(ContentExt ext);
}