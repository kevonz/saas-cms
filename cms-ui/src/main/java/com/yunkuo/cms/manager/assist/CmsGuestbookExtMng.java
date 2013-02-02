package com.yunkuo.cms.manager.assist;

import com.yunkuo.cms.entity.assist.CmsGuestbook;
import com.yunkuo.cms.entity.assist.CmsGuestbookExt;

public interface CmsGuestbookExtMng {
	public CmsGuestbookExt save(CmsGuestbookExt ext, CmsGuestbook guestbook);

	public CmsGuestbookExt update(CmsGuestbookExt ext);
}