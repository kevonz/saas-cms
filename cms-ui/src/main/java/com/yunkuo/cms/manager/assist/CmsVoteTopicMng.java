package com.yunkuo.cms.manager.assist;

import java.util.Collection;
import java.util.List;

import com.yunkuo.cms.entity.assist.CmsVoteItem;
import com.yunkuo.cms.entity.assist.CmsVoteTopic;
import com.yunkuo.cms.entity.main.CmsUser;
import com.yunkuo.common.page.Pagination;

public interface CmsVoteTopicMng {
	public Pagination getPage(Integer siteId, int pageNo, int pageSize);

	public CmsVoteTopic findById(Integer id);

	public CmsVoteTopic getDefTopic(Integer siteId);

	public CmsVoteTopic vote(Integer topicId, Integer[] itemIds, CmsUser user,
			String ip, String cookie);

	public CmsVoteTopic save(CmsVoteTopic bean, List<CmsVoteItem> items);

	public CmsVoteTopic update(CmsVoteTopic bean, Collection<CmsVoteItem> items);

	public CmsVoteTopic deleteById(Integer id);

	public CmsVoteTopic[] deleteByIds(Integer[] ids);
}