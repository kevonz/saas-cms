package com.yunkuo.cms.manager.main;

import com.yunkuo.cms.entity.main.CmsUser;
import com.yunkuo.cms.entity.main.CmsUserExt;

public interface CmsUserExtMng {
	public CmsUserExt save(CmsUserExt ext, CmsUser user);

	public CmsUserExt update(CmsUserExt ext, CmsUser user);
}