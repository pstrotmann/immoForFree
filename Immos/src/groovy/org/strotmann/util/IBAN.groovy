package org.strotmann.util

import org.apache.commons.lang3.StringUtils
// necessary components are imported

import org.apache.http.HttpEntity
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import org.json.JSONObject

class IBAN {
	
	static String ibanForm(String i) {
		"${i.substring(0,4)} ${i.substring(4,8)} ${i.substring(8,12)} ${i.substring(12,16)} ${i.substring(16,20)} ${i.substring(20,22)}"
	}
	
	static String ibanRein(String i) {
		"${i.replaceAll(" ", "")}"
	}
	
	/**
	 * This method creates a valid German IBAN
	 * @return Account number
	 */
	static String generateAccountNumber(String blz, String ktoNr) {
		String countryCode = "DE"
		String gerRecognitionNumber = "131400"
		String bban
		
		String accountNumber = StringUtils.leftPad(ktoNr, 10, '0')		

		bban = blz + accountNumber

		String checkSumString = bban + gerRecognitionNumber

		//calculate the checksum
		BigInteger checkSum = 98 - new BigInteger(checkSumString).mod(new BigInteger("97"))

		//if checksum is smaller than 10 add a leading 0
		if (checkSum.intValue() < 10) {
			checkSumString = "0" + checkSum.toString()
		} else {
			checkSumString = checkSum.toString()
		}

		return countryCode + checkSumString + blz + accountNumber
	}
	
	/**
	 * This method creates a valid German BIC from IBAN
	 * @return BIC
	 */
	static String generateBIC(String iban) {
		// essential URL structure is built using constants
		def String BASE_URL = "https://openiban.com/"
		def String ENDPOINT = "validate/"
		def String IBAN = iban
		def String funktion = "?getBIC=true"		
		String s = BASE_URL + ENDPOINT + IBAN + funktion	
		JSONObject jO = jObj(s)	
		JSONObject bankData = jO.getJSONObject("bankData")
		String bic = bankData.getString("bic")
		bic
	}
	
	static JSONObject jObj (String s) {
		// this object is used for executing requests to the (REST) API
		def CloseableHttpClient httpClient = HttpClients.createDefault()
		// The following line initializes the HttpGet Object with the URL in order to send a request
		HttpGet gApi = new HttpGet(s)
		CloseableHttpResponse resp
		try {
			resp =  httpClient.execute(gApi)
		} catch (Exception e) {
			e.printStackTrace()
		}
		HttpEntity entity = resp.getEntity()
		// the following line converts the JSON Response to an equivalent Java Object
		JSONObject jO = new JSONObject(EntityUtils.toString(entity))
		jO
	}
	
}

