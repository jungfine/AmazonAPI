package com.etoplighting.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etoplighting.domain.DetailsVO;
import com.etoplighting.persistence.DetailsDAO;

@Service
public class DetailsServiceImpl implements DetailsService {
	private static final Logger logger = LoggerFactory.getLogger(DetailsServiceImpl.class);

	@Inject
	private DetailsDAO dao;
	
	@Override
	public List<DetailsVO> detailsList() throws Exception {
		logger.info("DETAILS SERVICE IMPL >>>>>>>>>>");
		return dao.detailsList();
	}

	@Transactional
	@Override
	public void addProduct(DetailsVO vo) throws Exception{
		dao.create(vo);
	}
}
