package com.etoplighting.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuyboxVO {
	private static final Logger logger = LoggerFactory.getLogger(DetailsVO.class);
	private String img, title, asin, topSeller, topSellerPrice, ourPrice;
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
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public String getTopSeller() {
		return topSeller;
	}
	public void setTopSeller(String topSeller) {
		this.topSeller = topSeller;
	}
	public String getTopSellerPrice() {
		return topSellerPrice;
	}
	public void setTopSellerPrice(String topSellerPrice) {
		this.topSellerPrice = topSellerPrice;
	}
	public String getOurPrice() {
		return ourPrice;
	}
	public void setOurPrice(String ourPrice) {
		this.ourPrice = ourPrice;
	}
}
