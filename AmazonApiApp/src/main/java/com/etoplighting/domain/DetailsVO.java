package com.etoplighting.domain;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DetailsVO {
	private static final Logger logger = LoggerFactory.getLogger(DetailsVO.class);
	private String category, img, asin, title, reviews, rate, ranking, price, asinID;
	int id;
	
	//ID -> DB
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//ID -> DB
	// ASINID - > DB
	 public String getAsinID() {
		return asinID;
	}
	public void setAsinID(String asinID) {
		this.asinID = asinID;
	}
	// ASINID - > DB
	
	private List<DetailsVO> asinList;

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReviews() {
		return reviews;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
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
	public List<DetailsVO> getAsinList() {
		return asinList;
	}
	public void setAsinList(List<DetailsVO> asinList) {
		this.asinList = asinList;
	}
}
