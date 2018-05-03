package com.etoplighting.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etoplighting.service.BuyboxService;

@Controller
@RequestMapping("/buybox/*")
public class BuyboxController {
	private static final Logger logger = LoggerFactory.getLogger(DetailsController.class);
	
	@Inject
	private BuyboxService service;
	
	@RequestMapping(value="/buybox", method=RequestMethod.GET)
	public String details(Locale locale, Model model) throws Exception{
		model.addAttribute("buyboxList", service.buyboxList());		
		return "/buybox/buybox";
	}

}
