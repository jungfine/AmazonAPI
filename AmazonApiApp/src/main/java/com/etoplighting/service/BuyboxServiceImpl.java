package com.etoplighting.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.etoplighting.domain.BuyboxVO;
import com.etoplighting.persistence.BuyboxDAO;

@Service
public class BuyboxServiceImpl implements BuyboxService {
	private static final Logger logger = LoggerFactory.getLogger(DetailsServiceImpl.class);

	@Inject
	private BuyboxDAO dao;
	
	@Override
	public List<BuyboxVO> buyboxList() throws Exception {
		logger.info("BUYBOX SERVICE IMPL >>>>>>>>>>");
		return dao.buyboxList();
	}

}
