package com.yunkuo.cms.action.member;

import static com.yunkuo.cms.Constants.TPLDIR_MEMBER;
import static com.yunkuo.common.page.SimplePage.cpn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunkuo.cms.entity.main.CmsSite;
import com.yunkuo.cms.entity.main.CmsUser;
import com.yunkuo.cms.entity.main.MemberConfig;
import com.yunkuo.cms.manager.main.CmsUserMng;
import com.yunkuo.cms.manager.main.ContentMng;
import com.yunkuo.cms.web.CmsUtils;
import com.yunkuo.cms.web.FrontUtils;
import com.yunkuo.common.page.Pagination;
import com.yunkuo.common.web.CookieUtils;
import com.yunkuo.common.web.ResponseUtils;

/**
 * 收藏信息Action
 * 
 *
 * 
 */
@Controller
public class CollectionMemberAct {

	public static final String COLLECTION_LIST = "tpl.collectionList";

	/**
	 * 我的收藏信息
	 * 
	 * 如果没有登录则跳转到登陆页
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/member/collection_list")
	public String collection_list(String queryTitle, Integer queryChannelId,
			Integer pageNo, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		CmsUser user = CmsUtils.getUser(request);
		FrontUtils.frontData(request, model, site);
		MemberConfig mcfg = site.getConfig().getMemberConfig();
		// 没有开启会员功能
		if (!mcfg.isMemberOn()) {
			return FrontUtils.showMessage(request, model, "member.memberClose");
		}
		if (user == null) {
			return FrontUtils.showLogin(request, model, site);
		}
		Pagination p = contentMng.getPageForCollection(site.getId(), user
				.getId(), cpn(pageNo), CookieUtils.getPageSize(request));
		model.addAttribute("pagination", p);
		if (!StringUtils.isBlank(queryTitle)) {
			model.addAttribute("queryTitle", queryTitle);
		}
		if (queryChannelId != null) {
			model.addAttribute("queryChannelId", queryChannelId);
		}
		return FrontUtils.getTplPath(request, site.getSolutionPath(),
				TPLDIR_MEMBER, COLLECTION_LIST);
	}

	@RequestMapping(value = "/member/collect")
	public void collect(Integer cId, Integer operate,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws JSONException {
		CmsUser user = CmsUtils.getUser(request);
		JSONObject object = new JSONObject();
		if (user == null) {
			object.put("result", false);
		} else {
			object.put("result", true);
			userMng.updateUserConllection(user,cId,operate);
		}
		ResponseUtils.renderJson(response, object.toString());
	}

	@RequestMapping(value = "/member/collect_exist")
	public void collect_exist(Integer cId, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws JSONException {
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
		CmsUser user = CmsUtils.getUser(request);
		JSONObject object = new JSONObject();
		FrontUtils.frontData(request, model, site);
		if (user == null) {
			object.put("result", false);
		} else {
			if (user.getCollectContents().contains(contentMng.findById(cId))) {
				object.put("result", true);
			} else {
				object.put("result", false);
			}
		}
		ResponseUtils.renderJson(response, object.toString());
	}

	@Autowired
	private ContentMng contentMng;
	@Autowired
	private CmsUserMng userMng;

}
