package com.etoplighting.controller;



import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.etoplighting.service.RankingService;


@Controller
@RequestMapping("/ranking/*")
public class RankingController {
	private static final Logger logger = LoggerFactory.getLogger(RankingController.class);
	
	@Inject
	private RankingService service;

	@RequestMapping(value="/ranking", method=RequestMethod.GET)
	public String ranking(Locale locale, Model model) throws Exception {
		logger.info("RANKING CONTROLLER >>>>> ");
		
		model.addAttribute("rankingList", service.rankingList());

		return "/ranking/ranking";
	}
	
}