package com.fastcampus.ch22;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class RegisterController {
	@RequestMapping(value="C", method= {RequestMethod.GET, RequestMethod.POST})
	public String register() { 
		return "registerForm"; //WEB-INF/views/registerFrom.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")
	public String save(User user, Model m) throws Exception {
		//��ȿ�� �˻�
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
			
			m.addAttribute("msg", msg);
			return"forward:/register/add";
		//	return"redirect:/register/add?msg="+msg; //URL���ۼ�(rewriting)
			
		}
		
				return "registerInfo";
	}

	private boolean isValid(User user) {
			return false;
	}
}