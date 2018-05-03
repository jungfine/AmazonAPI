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
import com.etoplighting.domain.BuyboxVO;

@Repository
public class BuyboxDAOImpl implements BuyboxDAO {
	private static final Logger logger = LoggerFactory.getLogger(DetailsDAOImpl.class);

	private static final String AWS_ACCESS_KEY_ID = "AKIAJ4TZGTUTHUNMWSBQ";
	private static final String AWS_SECRET_KEY = "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";
	private static final String AssociateTag = "loadsstudi0a-20";
	private static final String ENDPOINT = "webservices.amazon.com";

	@Override
	public List<BuyboxVO> buyboxList() {
		logger.info("BUYBOX DAO Impl >>>>>>>>>>");
		String asinID="B00E6GRHBO";
		String asinID2="B078L3ZP9Z";

		// GET AMAZON API FILE BY ASIN
		String requestUrl = getAmazonapi(asinID);
		System.out.println("Signed Request is \"" + requestUrl + "\"");	
		// MAKE API DATA LIST
		List<BuyboxVO> vo = new ArrayList<BuyboxVO>();					
		BuyboxVO list = new BuyboxVO();
		list = getAmazonData(requestUrl);
		vo.add(list);
		
		requestUrl = getAmazonapi(asinID2);
		System.out.println("Signed Request is \"" + requestUrl + "\"");	
		// MAKE API DATA LIST				
		BuyboxVO list2 = new BuyboxVO();
		list2 = getAmazonData(requestUrl);
		vo.add(list2);
		
		return vo;
	}
	
	
	private BuyboxVO getAmazonData(String requestUrl)
	{
		BuyboxVO list = new BuyboxVO();
		
		String img = fetchImage(requestUrl);
		String asin = fetchASIN(requestUrl);
		String title = fetchTitle(requestUrl);
		String topSeller = fetchTopSeller(requestUrl);
		String topSellerPrice = fetchTopSellerPrice(requestUrl);

		
		System.out.println("CHECK >>>");
		
		list.setImg(img);
		list.setAsin(asin);
		list.setTitle(title);
		list.setTopSeller(topSeller);
		list.setTopSellerPrice(topSellerPrice);

		return list;
	}



	private String getAmazonapi(String asinID) {

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
		params.put("ItemId", asinID);
		params.put("ResponseGroup", "Large, OfferFull");
		params.put("IdType", "ASIN");
		params.put("AssociateTag", "loadsstudi0a-20");

		requestUrl = helper.sign(params);
		return requestUrl;
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

	private String fetchASIN(String requestUrl) {
		//ItemId
		String ASIN = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(requestUrl);
			Node ASINNode = doc.getElementsByTagName("ItemId").item(0);
			ASIN = ASINNode.getTextContent();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return ASIN;
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
	private static String fetchTopSellerPrice(String requestUrl) {
		String offerPrice = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(requestUrl);
            Node offerPriceNode = doc.getElementsByTagName("Price").item(0).getFirstChild().getNextSibling().getNextSibling();
            offerPrice = offerPriceNode.getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return offerPrice;
	}

	private static String fetchTopSeller(String requestUrl) {
		String merchant = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(requestUrl);
            Node merchantNode = doc.getElementsByTagName("Merchant").item(0);
            merchant = merchantNode.getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return merchant;
	}



}
