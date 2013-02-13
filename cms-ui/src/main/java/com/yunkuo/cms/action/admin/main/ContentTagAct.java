package com.yunkuo.cms.action.admin.main;

import static com.yunkuo.common.page.SimplePage.cpn;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunkuo.cms.entity.main.CmsSite;
import com.yunkuo.cms.entity.main.ContentTag;
import com.yunkuo.cms.manager.main.CmsLogMng;
import com.yunkuo.cms.manager.main.ContentTagMng;
import com.yunkuo.cms.web.CmsUtils;
import com.yunkuo.cms.web.WebErrors;
import com.yunkuo.common.page.Pagination;
import com.yunkuo.common.web.CookieUtils;
import com.yunkuo.common.web.RequestUtils;

@Controller
public class ContentTagAct {
	private static final Logger log = LoggerFactory
			.getLogger(ContentTagAct.class);

	@RequestMapping("/tag/v_list")
	public String list(Integer pageNo, HttpServletRequest request,
			ModelMap model) {
		String queryName = RequestUtils.getQueryParam(request, "queryName");
		Pagination pagination = manager.getPage(queryName, cpn(pageNo),
				CookieUtils.getPageSize(request));
		model.addAttribute("pagination", pagination);
		if (!StringUtils.isBlank(queryName)) {
			model.addAttribute("queryName", queryName);
		}
		return "tag/list";
	}

	@RequestMapping("/tag/v_add")
	public String add(ModelMap model) {
		return "tag/add";
	}

	@RequestMapping("/tag/v_edit")
	public String edit(Integer id, HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateEdit(id, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		model.addAttribute("contentTag", manager.findById(id));
		String queryName = RequestUtils.getQueryParam(request, "queryName");
		if (!StringUtils.isBlank(queryName)) {
			model.addAttribute("queryName", queryName);
		}
		return "tag/edit";
	}

	@RequestMapping("/tag/o_save")
	public String save(ContentTag bean, HttpServletRequest request,
			ModelMap model) {
		WebErrors errors = validateSave(bean, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		bean = manager.save(bean);
		log.info("save ContentTag id={}", bean.getId());
		cmsLogMng.operating(request, "contentTag.log.save", "id="
				+ bean.getId() + ";name=" + bean.getName());
		return "redirect:v_list";
	}

	@RequestMapping("/tag/o_update")
	public String update(ContentTag bean, Integer pageNo,
			HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateUpdate(bean.getId(), request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		bean = manager.update(bean);
		log.info("update ContentTag id={}.", bean.getId());
		cmsLogMng.operating(request, "contentTag.log.update", "id="
				+ bean.getId() + ";name=" + bean.getName());
		return list(pageNo, request, model);
	}

	@RequestMapping("/tag/o_delete")
	public String delete(Integer[] ids, Integer pageNo,
			HttpServletRequest request, ModelMap model) {
		WebErrors errors = validateDelete(ids, request);
		if (errors.hasErrors()) {
			return errors.showErrorPage(model);
		}
		ContentTag[] beans = manager.deleteByIds(ids);
		for (ContentTag bean : beans) {
			log.info("delete ContentTag id={}", bean.getId());
			cmsLogMng.operating(request, "contentTag.log.delete", "id="
					+ bean.getId() + ";name=" + bean.getName());
		}
		return list(pageNo, request, model);
	}

	private WebErrors validateSave(ContentTag bean, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		return errors;
	}

	private WebErrors validateEdit(Integer id, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		CmsSite site = CmsUtils.getSite(request);
		if (vldExist(id, site.getId(), errors)) {
			return errors;
		}
		return errors;
	}

	private WebErrors validateUpdate(Integer id, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		CmsSite site = CmsUtils.getSite(request);
		if (vldExist(id, site.getId(), errors)) {
			return errors;
		}
		return errors;
	}

	private WebErrors validateDelete(Integer[] ids, HttpServletRequest request) {
		WebErrors errors = WebErrors.create(request);
		CmsSite site = CmsUtils.getSite(request);
		errors.ifEmpty(ids, "ids");
		for (Integer id : ids) {
			vldExist(id, site.getId(), errors);
		}
		return errors;
	}

	private boolean vldExist(Integer id, Integer siteId, WebErrors errors) {
		if (errors.ifNull(id, "id")) {
			return true;
		}
		ContentTag entity = manager.findById(id);
		if (errors.ifNotExist(entity, ContentTag.class, id)) {
			return true;
		}
		return false;
	}

	@Autowired
	private CmsLogMng cmsLogMng;
	@Autowired
	private ContentTagMng manager;
}