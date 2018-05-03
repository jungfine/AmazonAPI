package com.etoplighting.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/review/*")
public class ReviewController {
	private static final Logger logger = LoggerFactory.getLogger(RankingController.class);
	
	@RequestMapping(value="/review", method=RequestMethod.GET)
	public String ranking(Locale locale, Model model) throws Exception {
		logger.info("REVIEW CONTROLLER >>>>> ");
		
		//model.addAttribute("rankingList", service.rankingList());

		return "/review/review";
	}
}
