package com.etoplighting.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etoplighting.domain.RankingVO;
import com.etoplighting.persistence.RankingDAO;

@Service
public class RankingServiceImpl implements RankingService {
	private static final Logger logger = LoggerFactory.getLogger(RankingServiceImpl.class);

	@Inject
	private RankingDAO dao;
	
	@Transactional
	@Override
	public List<RankingVO> rankingList() throws Exception {
		logger.info("Ranking Service Impl >>>>> ");
		return dao.rankingList();
	}

}
