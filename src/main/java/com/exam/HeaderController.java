package com.exam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exam.Data.MessageData;







@Controller
public class HeaderController {
	String email;
	@RequestMapping("/aboutUs")
	public String aboutUs() {
		return "aboutUs";
	}
	


	
	
	@RequestMapping("/messageTo")
	public String m2(Model model, @ModelAttribute() Message m, RedirectAttributes ra ) {
		MessageData da= new MessageData();
		da.doInsert(m);
		ra.addFlashAttribute("message", "Welcome " +m.name+ " for your importent counsel");
		return "redirect:/messageUs";
	}
	
	


}
