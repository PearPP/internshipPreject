package com.oceantest.web.newcase.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/policy-info")
public class PolicyAction {
	
	@RequestMapping("/index.html")
	public String index() {
		//fwd to policy-info.jsp (ตามที่คอนฟิก pattern ไว้ที่ไฟล์ OceanTestWebConfig.java)
		//return "policy-info";
		
		return "/WEB-INF/views/policy-info.jsp";
	}
	
	
}
