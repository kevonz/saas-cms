package com.yunkuo.cms.action.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrameAct {
	@RequestMapping("/frame/config_main")
	public String configMain(ModelMap model) {
		return "frame/config_main";
	}

	@RequestMapping("/frame/config_left")
	public String configLeft(ModelMap model) {
		return "frame/config_left";
	}

	@RequestMapping("/frame/config_right")
	public String configRight(ModelMap model) {
		return "frame/config_right";
	}

	@RequestMapping("/frame/user_main")
	public String userMain(ModelMap model) {
		return "frame/user_main";
	}

	@RequestMapping("/frame/user_left")
	public String userLeft(ModelMap model) {
		return "frame/user_left";
	}

	@RequestMapping("/frame/user_right")
	public String userRight(ModelMap model) {
		return "frame/user_right";
	}

	@RequestMapping("/frame/generate_main")
	public String generateMain(ModelMap model) {
		return "frame/generate_main";
	}

	@RequestMapping("/frame/generate_left")
	public String generateLeft(ModelMap model) {
		return "frame/generate_left";
	}

	@RequestMapping("/frame/generate_right")
	public String generateRight(ModelMap model) {
		return "frame/generate_right";
	}

	@RequestMapping("/frame/maintain_main")
	public String maintainMain(ModelMap model) {
		return "frame/maintain_main";
	}

	@RequestMapping("/frame/maintain_left")
	public String maintainLeft(ModelMap model) {
		return "frame/maintain_left";
	}

	@RequestMapping("/frame/maintain_right")
	public String maintainRight(ModelMap model) {
		return "frame/maintain_right";
	}

	@RequestMapping("/frame/assistant_main")
	public String assistantMain(ModelMap model) {
		return "frame/assistant_main";
	}

	@RequestMapping("/frame/assistant_left")
	public String assistantLeft(ModelMap model) {
		return "frame/assistant_left";
	}

	@RequestMapping("/frame/assistant_right")
	public String assistantRight(ModelMap model) {
		return "frame/assistant_right";
	}

	@RequestMapping("/frame/template_main")
	public String templateMain(ModelMap model) {
		return "frame/template_main";
	}

	@RequestMapping("/frame/resource_main")
	public String resourceMain(ModelMap model) {
		return "frame/resource_main";
	}

	@RequestMapping("/frame/channel_main")
	public String channelMain(ModelMap model) {
		return "frame/channel_main";
	}

	@RequestMapping("/frame/content_main")
	public String contentMain(ModelMap model) {
		return "frame/content_main";
	}
	
	@RequestMapping("/frame/statistic_main")
	public String statisticMain(ModelMap model) {
		return "frame/statistic_main";
	}
	
	@RequestMapping("/frame/statistic_left")
	public String statisticLeft(){
		return "frame/statistic_left";
	}
	
	@RequestMapping("/frame/statistic_right")
	public String statisticRight(){
		return "frame/statistic_right";
	}
}
