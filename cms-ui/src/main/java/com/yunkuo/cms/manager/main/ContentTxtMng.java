package com.yunkuo.cms.manager.main;

import com.yunkuo.cms.entity.main.Content;
import com.yunkuo.cms.entity.main.ContentTxt;

public interface ContentTxtMng {
	public ContentTxt save(ContentTxt txt, Content content);

	public ContentTxt update(ContentTxt txt, Content content);
}