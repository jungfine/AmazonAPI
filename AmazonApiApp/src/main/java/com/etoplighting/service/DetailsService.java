package com.etoplighting.service;

import java.util.List;

import com.etoplighting.domain.DetailsVO;

public interface DetailsService {
	
	public List<DetailsVO> detailsList() throws Exception;

	public void addProduct(DetailsVO vo) throws Exception;



}
