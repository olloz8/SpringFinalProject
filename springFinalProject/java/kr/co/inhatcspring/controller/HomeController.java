package kr.co.inhatcspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 프로젝트 root 실행 컨트롤러입니다.	
 */
@Controller
public class HomeController {
	
	//프로젝트 root 실행 시, main page로 이동합니다.	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "main";
	}
	
}

