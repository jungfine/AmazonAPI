package com.etoplighting.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.etoplighting.amazonapi.SignedRequestsHelper;
import com.etoplighting.domain.DetailsVO;

@Repository
public class DetailsDAOImpl implements DetailsDAO {
	private static final Logger logger = LoggerFactory.getLogger(DetailsDAOImpl.class);

	private static final String AWS_ACCESS_KEY_ID = "AKIAJ4TZGTUTHUNMWSBQ";
	private static final String AWS_SECRET_KEY = "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";
	private static final String AssociateTag = "loadsstudi0a-20";
	private static final String ENDPOINT = "webservices.amazon.com";

	//private static final String IdType = "ASIN";
	//private static String ITEM_ID = "B00E6GRHBO";
	@Inject
	private SqlSession sql;

	private static String namespace="com.etoplighting.mapper.DetailsMapper";


	@Override
	public List<DetailsVO> detailsList() throws Exception{
		logger.info("Details DAO Impl >>>>>>>>>>");
		String asinID="B00E6GRHBO";
		String asinID2="B01MZ0PBLQ";

		// GET AMAZON API FILE BY ASIN
		String requestUrl = getAmazonapi(asinID);
		System.out.println("Signed Request is \"" + requestUrl + "\"");	
		// MAKE API DATA LIST
		List<DetailsVO> vo = new ArrayList<DetailsVO>();					
		DetailsVO list = new DetailsVO();
		list = getAmazonData(requestUrl);
		vo.add(list);
		System.out.println("CHECK");
		
		listAsin();
		System.out.println(listAsin());
		
		requestUrl = getAmazonapi(asinID2);
		System.out.println("Signed Request is \"" + requestUrl + "\"");	
		// MAKE API DATA LIST				
		DetailsVO list2 = new DetailsVO();
		list2 = getAmazonData(requestUrl);
		vo.add(list2);
		
		return vo;
	}
	
	@Override
	public void create(DetailsVO vo) throws Exception {
		logger.info("create(.......vo >>>"+vo.toString());
		sql.insert(namespace+".create", vo);
	}
	
	@Override
	public List<DetailsVO> listAsin() throws Exception {
		System.out.println("LOAD ASIN ID ");
		return sql.selectList(namespace+".listAsin");
	}
	
	private DetailsVO getAmazonData(String requestUrl)
	{
		DetailsVO list = new DetailsVO();
		String reviewInfo = reviewIframe(requestUrl);
		String category = fetchCategroy(requestUrl);
		String img = fetchImage(requestUrl);
		String asin = fetchASIN(requestUrl);
		String title = fetchTitle(requestUrl);
		System.out.println("CHECK >>>");
		System.out.println("reviewInfo >>>"+reviewInfo);
		
		String reviews = fetchReviews(reviewInfo);
		System.out.println("reviews number : "+reviews);
		String rate = fetchRate(reviewInfo);
		System.out.println("reviews rate : "+rate);
		String ranking = fetchRanking(requestUrl);
		String price  = fetchPrice(requestUrl);
		
		list.setCategory(category);
		list.setImg(img);
		list.setAsin(asin);
		list.setTitle(title);
		list.setReviews(reviews);
		list.setRate(rate);
		list.setRanking(ranking);
		list.setPrice(price);		
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

	private String fetchRanking(String requestUrl) {
		// TODO Auto-generated method stub
		return "Ranking";
	}

	private String reviewIframe(String customerReviews) {
        String reviewUrl = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(customerReviews);
            //Get First Child Node from Customer Reviews Tag
            Node reviewNode = doc.getElementsByTagName("CustomerReviews").item(0).getFirstChild();
            reviewUrl = reviewNode.getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return reviewUrl;
    
	}
	private static String fetchReviews(String requestUrl) {
		String reviewNum = "";
		System.out.println("CUSTOMEREVIEW : "+requestUrl);
		org.jsoup.nodes.Document doc;
		try {
			doc = Jsoup.connect(requestUrl).get();
			Elements review = doc.select("div.crIFrameHeaderHistogram").select("div.tiny");	
			for(Element e: review) 
			{
				reviewNum +=e.text();
				reviewNum +="\n";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return reviewNum;
	}
	private static String fetchRate(String requestUrl) {
		String reviewRateValue ="";
		
		org.jsoup.nodes.Document doc;
		try {
			doc = Jsoup.connect(requestUrl).get();
			Elements reviewimg=doc.getElementsByTag("img");

			int counter=0;
			int counter2=0;
            for (Element el : reviewimg)
            {
                // If alt is empty or null, add one to counter
                if(el.attr("alt") == null || el.attr("alt").equals("")) {
                    counter++;
                }
                else {
                	counter2++;
                }
                if(counter2==2) {
                	reviewRateValue=el.attr("alt");
                	break;
                }
                
                System.out.println("image tag: " + el.attr("src") + " Alt: " + el.attr("alt"));
            }
            System.out.println("Number of unset alt: " + counter);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return reviewRateValue;
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

	private String fetchCategroy(String requestUrl) {
		String category = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(requestUrl);
			Node categoryNode = doc.getElementsByTagName("BrowseNodes").item(0).getFirstChild().getFirstChild().getNextSibling();
			category = categoryNode.getTextContent();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return category;
	}
}