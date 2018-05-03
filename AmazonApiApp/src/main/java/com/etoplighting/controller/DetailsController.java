package com.etoplighting.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.etoplighting.domain.DetailsVO;
import com.etoplighting.service.DetailsService;

@Controller
@RequestMapping("/details/*")
public class DetailsController {
	private static final Logger logger = LoggerFactory.getLogger(DetailsController.class);
	
	@Inject
	private DetailsService service;
	
	@RequestMapping(value="/details", method=RequestMethod.GET)
	public String details(Locale locale, Model model) throws Exception{
		model.addAttribute("detailsList", service.detailsList());		
		return "/details/details";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST) 
	public String productAddPost(DetailsVO vo, RedirectAttributes rttr)throws Exception 
	{
		logger.info("registPOST(.........vo >>> "+vo.toString());
		service.addProduct(vo);
		rttr.addAttribute("msg", "success");
		return "redirect:/details/details";
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public void productAddGET(DetailsVO vo, Model model) throws Exception {
		logger.info("registGET(.........vo >>> "+vo.toString());
	}
}
