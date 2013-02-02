package com.yunkuo.cms.manager.assist;

import com.yunkuo.cms.entity.assist.CmsComment;
import com.yunkuo.cms.entity.assist.CmsCommentExt;

public interface CmsCommentExtMng {
	public CmsCommentExt save(String ip, String text, CmsComment comment);

	public CmsCommentExt update(CmsCommentExt bean);

	public int deleteByContentId(Integer contentId);
}