package com.etoplighting.persistence;

import java.util.List;

import com.etoplighting.domain.DetailsVO;

public interface DetailsDAO {
	List<DetailsVO> detailsList() throws Exception;
	public void create(DetailsVO vo) throws Exception; 
	public List<DetailsVO> listAsin() throws Exception;
}
