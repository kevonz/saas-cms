package com.yunkuo.cms.web.site.controller;

import static com.yunkuo.cms.Constants.TPLDIR_SPECIAL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yunkuo.cms.entity.main.CmsSite;
import com.yunkuo.cms.web.CmsUtils;
import com.yunkuo.cms.web.FrontUtils;

@Controller
public class RssController {
	public static final String RSS_TPL = "tpl.rss";

	@RequestMapping(value = "/rss", method = RequestMethod.GET)
	public String rss(HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		response.setContentType("text/xml;charset=UTF-8");
		CmsSite site = CmsUtils.getSite(request);
		FrontUtils.frontData(request, model, site);
		return FrontUtils.getTplPath(request, site.getSolutionPath(),
				TPLDIR_SPECIAL, RSS_TPL);
	}
}
