package com.etoplighting.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RankingVO {
	private static final Logger logger = LoggerFactory.getLogger(RankingVO.class);
	
	private String img, title, seller, ranking,	price;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
