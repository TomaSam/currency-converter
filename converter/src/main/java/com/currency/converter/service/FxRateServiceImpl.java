package com.currency.converter.service;

import java.math.BigDecimal;
import java.net.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.currency.converter.entity.FxRate;
import com.currency.converter.repositories.FxRateRepository;


@Service
public class FxRateServiceImpl implements FxRateService {
	
	@Autowired
	private FxRateRepository rateRepository;
	
	public FxRate findByCurrency(String currency) {
		return rateRepository.findAll().stream().filter(rate -> rate.getCurrency().equals(currency)).findFirst().orElse(null);
	}
	
	public boolean existByCurrency(String currency) {
		if (rateRepository.findAll().stream().anyMatch(element -> element.getCurrency().equals(currency)));
		return true;
		
	}
	
	public void saveRatesToRepository() throws Exception {
		
		try {
			URL url = new URL("http://www.lb.lt/webservices/fxrates/FxRates.asmx/getCurrentFxRates?tp=EU");
			URLConnection urlConnection = url.openConnection();
			urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
			//an instance of factory that gives a document builder  
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			//an instance of builder to parse the specified xml file 
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(urlConnection.getInputStream());
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("CcyAmt");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp);
				
				Element eElement = (Element) nNode;
				
				if (!eElement.getElementsByTagName("Ccy").item(0).getTextContent().equals("EUR")) {
					
					String currency = eElement.getElementsByTagName("Ccy").item(0).getTextContent();
					
					BigDecimal rate = new BigDecimal(eElement.getElementsByTagName("Amt").item(0)
							.getTextContent()).setScale(2, BigDecimal.ROUND_DOWN);
				
					FxRate updateRate = findByCurrency(currency);
					updateRate.setRate(rate);
					System.out.println(updateRate.getCurrency() + " " + updateRate.getRate());
					rateRepository.save(updateRate);
					
				}	
			}
			
			System.out.println("Repository updated");

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
