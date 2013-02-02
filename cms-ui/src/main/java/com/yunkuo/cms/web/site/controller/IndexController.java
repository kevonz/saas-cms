package com.yunkuo.cms.web.site.controller;

import static com.yunkuo.cms.Constants.TPLDIR_MEMBER;
import static com.yunkuo.core.action.front.LoginAct.MESSAGE;
import static com.yunkuo.core.action.front.LoginAct.PROCESS_URL;
import static com.yunkuo.core.action.front.LoginAct.RETURN_URL;
import static com.yunkuo.core.manager.AuthenticationMng.AUTH_KEY;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.octo.captcha.service.image.ImageCaptchaService;
import com.yunkuo.cms.action.member.CasLoginAct;
import com.yunkuo.cms.entity.main.CmsSite;
import com.yunkuo.cms.manager.main.CmsUserMng;
import com.yunkuo.cms.web.CmsUtils;
import com.yunkuo.cms.web.FrontUtils;
import com.yunkuo.common.web.CookieUtils;
import com.yunkuo.common.web.RequestUtils;
import com.yunkuo.common.web.session.SessionProvider;
import com.yunkuo.core.entity.Authentication;
import com.yunkuo.core.entity.Config.ConfigLogin;
import com.yunkuo.core.manager.AuthenticationMng;
import com.yunkuo.core.manager.ConfigMng;
import com.yunkuo.core.manager.UnifiedUserMng;

@Controller
public class IndexController {

	@RequestMapping(value = "/index/test", method = RequestMethod.GET)
	public ModelAndView test(){
		ModelAndView mav=new ModelAndView();		
		return mav;
	}
	
	//####
	@Autowired
	private CmsUserMng cmsUserMng;
	@Autowired
	private ConfigMng configMng;
	@Autowired
	private AuthenticationMng authMng;
	@Autowired
	private UnifiedUserMng unifiedUserMng;
	@Autowired
	private ImageCaptchaService imageCaptchaService;
	@Autowired
	private SessionProvider session;
	
	/**
	 * 获得地址
	 * 
	 * @param processUrl
	 * @param returnUrl
	 * @param authId
	 * @param defaultUrl
	 * @return
	 */
	private String getView(String processUrl, String returnUrl, String authId) {
		if (!StringUtils.isBlank(processUrl)) {
			StringBuilder sb = new StringBuilder("redirect:");
			sb.append(processUrl).append("?").append(AUTH_KEY).append("=")
					.append(authId);
			if (!StringUtils.isBlank(returnUrl)) {
				sb.append("&").append(RETURN_URL).append("=").append(returnUrl);
			}
			return sb.toString();
		} else if (!StringUtils.isBlank(returnUrl)) {
			StringBuilder sb = new StringBuilder("redirect:");
			sb.append(returnUrl);
			return sb.toString();
		} else {
			return null;
		}
	}

	private void writeCookieErrorRemaining(Integer userErrorRemaining,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		// 所有访问的页面都需要写一个cookie，这样可以判断已经登录了几次。
		Integer errorRemaining = getCookieErrorRemaining(request, response);
		ConfigLogin configLogin = configMng.getConfigLogin();
		Integer errorInterval = configLogin.getErrorInterval();
		if (userErrorRemaining != null
				&& (errorRemaining == null || userErrorRemaining < errorRemaining)) {
			errorRemaining = userErrorRemaining;
		}
		int maxErrorTimes = configLogin.getErrorTimes();
		if (errorRemaining == null || errorRemaining > maxErrorTimes) {
			errorRemaining = maxErrorTimes;
		} else if (errorRemaining <= 0) {
			errorRemaining = 0;
		} else {
			errorRemaining--;
		}
		model.addAttribute("errorRemaining", errorRemaining);
		CookieUtils.addCookie(request, response, COOKIE_ERROR_REMAINING,
				errorRemaining.toString(), errorInterval * 60, null);
	}

	private Integer getCookieErrorRemaining(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie cookie = CookieUtils.getCookie(request, COOKIE_ERROR_REMAINING);
		if (cookie != null) {
			String value = cookie.getValue();
			if (NumberUtils.isDigits(value)) {
				return Integer.parseInt(value);
			}
		}
		return null;
	}

	private void removeCookieErrorRemaining(HttpServletRequest request,
			HttpServletResponse response) {
		CookieUtils.cancleCookie(request, response, COOKIE_ERROR_REMAINING,
				null);
	}
	//####
	
	private static final Logger log = LoggerFactory
			.getLogger(CasLoginAct.class);

	public static final String COOKIE_ERROR_REMAINING = "_error_remaining";
	public static final String LOGIN_INPUT = "tpl.loginInput";
	public static final String LOGIN_STATUS = "tpl.loginStatus";

	@RequestMapping(value = "/testlogin", method = RequestMethod.GET)
	public String testlogin(HttpServletRequest request, ModelMap model) {
		CmsSite site = CmsUtils.getSite(request);
		String sol = site.getSolutionPath();
		String processUrl = RequestUtils.getQueryParam(request, PROCESS_URL);
		String returnUrl = RequestUtils.getQueryParam(request, RETURN_URL);
		String message = RequestUtils.getQueryParam(request, MESSAGE);
		String authId = (String) session.getAttribute(request, AUTH_KEY);
		if (authId != null) {
			// 存在认证ID
			Authentication auth = authMng.retrieve(authId);
			// 存在认证信息，且未过期
			if (auth != null) {
				String view = getView(processUrl, returnUrl, auth.getId());
				if (view != null) {
					return view;
				} else {
					FrontUtils.frontData(request, model, site);
					model.addAttribute("auth", auth);
					return FrontUtils.getTplPath(request, sol, TPLDIR_MEMBER,
							LOGIN_STATUS);
				}
			}
		}
		FrontUtils.frontData(request, model, site);
		if (!StringUtils.isBlank(processUrl)) {
			model.addAttribute(PROCESS_URL, processUrl);
		}
		if (!StringUtils.isBlank(returnUrl)) {
			model.addAttribute(RETURN_URL, returnUrl);
		}
		if (!StringUtils.isBlank(message)) {
			model.addAttribute(MESSAGE, message);
		}
		return FrontUtils.getTplPath(request, sol, TPLDIR_MEMBER, LOGIN_INPUT);
	}
}
