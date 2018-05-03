package com.etoplighting.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.etoplighting.amazonapi.SignedRequestsHelper;
import com.etoplighting.domain.RankingVO;

@Repository
public class RankingDAOImpl implements RankingDAO {
	private static final Logger logger = LoggerFactory.getLogger(RankingDAOImpl.class);

	private static final String AWS_ACCESS_KEY_ID = "AKIAJ4TZGTUTHUNMWSBQ";
	private static final String AWS_SECRET_KEY = "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";
	private static final String AssociateTag = "loadsstudi0a-20";
	private static final String ENDPOINT = "webservices.amazon.com";

	private static final String IdType = "ASIN";
	private static final String ITEM_ID = "B00E6GRHBO";

	@Override
	public List<RankingVO> rankingList() {
		logger.info("Ranking DAO Impl >>>>> ");

		SignedRequestsHelper helper;
		try {
			helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY, AssociateTag);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		String requestUrl = null;

		System.out.println("Map form example:");
		Map<String, String> params = new HashMap<String, String>();
		params.put("Service", "AWSECommerceService");
		params.put("Version", "2018-04-25");
		params.put("Operation", "ItemLookup");
		params.put("ItemId", ITEM_ID);
		params.put("ResponseGroup", "Large, OfferFull");
		params.put("IdType", "ASIN");
		params.put("AssociateTag", "loadsstudi0a-20");

		requestUrl = helper.sign(params);
		System.out.println("Signed Request is \"" + requestUrl + "\"");

		
		List<RankingVO> vo = new ArrayList<RankingVO>();

		RankingVO list = new RankingVO();
		
		String img = fetchImage(requestUrl);
        System.out.println("image link is \"" + img + "\"");
		list.setImg(img);
		
		String price = fetchPrice(requestUrl);
        System.out.println("price is \"" + price + "\"");
		list.setPrice(price);
		
		//String ranking = fetchRanking(requestUrl);
        //System.out.println("ranking is \"" + ranking + "\"");
		list.setRanking("RANKING");
		
		String seller = fetchSeller(requestUrl);		
        System.out.println("Signed Brand is \"" + seller + "\"");
		list.setSeller(seller);
		
		String title = fetchTitle(requestUrl);
		System.out.println("Signed Title is \"" + title + "\"");
		list.setTitle(title);

		vo.add(list);

		return vo;
	}

	private String fetchSeller(String requestUrl) {
		String brand = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(requestUrl);
			Node brandNode = doc.getElementsByTagName("Brand").item(0);
			brand = brandNode.getTextContent();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return brand;
	}

	private String fetchRanking(String requestUrl) {
		String rank = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(requestUrl);
			Node brandNode = doc.getElementsByTagName("SalesRank").item(0);
			rank = brandNode.getTextContent();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return rank;
	}

	private String fetchPrice(String requestUrl) {
		String offerPrice = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(requestUrl);
			Node offerPriceNode = doc.getElementsByTagName("FormattedPrice").item(0);
			offerPrice = offerPriceNode.getTextContent();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return offerPrice;
	}

	private String fetchImage(String requestUrl) {
		String img = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(requestUrl);
			Node imgPriceNode = doc.getElementsByTagName("MediumImage").item(0).getFirstChild();
			img = imgPriceNode.getTextContent();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return img;
	}

	private String fetchTitle(String requestUrl) {
		String title = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(requestUrl);
			Node titleNode = doc.getElementsByTagName("Title").item(0);
			title = titleNode.getTextContent();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return title;
	}

}
