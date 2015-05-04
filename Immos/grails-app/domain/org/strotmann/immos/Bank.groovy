package org.strotmann.immos

import java.util.Map;

import grails.plugins.rest.client.*
import grails.util.Holders

import org.codehaus.groovy.grails.web.json.JSONObject
import org.codehaus.groovy.grails.web.json.JSONArray

class Bank {
	
	String bic
	int blz
	String bankname
	int plz
	String ort
			
	String toString() {"${this.bankname}"}
		
	static Map bankdaten (Integer blz, String bic) {
		Map bkMap = [:]
		Map map = [:]
		def RestBuilder rest = new RestBuilder()
		RestResponse resp
		if(blz)
			resp = rest.get("${Holders.config.bicService}/bankIdentCode/get?blz=${blz}")
		if(bic)
			resp = rest.get("${Holders.config.bicService}/bankIdentCode/get?bic=${bic}")
		String s
		boolean mehrdeutig = false
		s = resp.getJson().getAt("bic")
		if (s.contains(","))
		mehrdeutig = true
		map["bic"] = s
		s = resp.getJson().getAt("bankname")
		map["bankname"] = s
		s = resp.getJson().getAt("plz")
		map["plz"] = s
		s = resp.getJson().getAt("ort")
		map["ort"] = s
		s = resp.getJson().getAt("blz")
		map["blz"] = s
		map.each {key, value -> bkMap[key] = (value.replace('[', '').replace(']', '')).split(',')[0]
			if (mehrdeutig && key == 'bic')
				bkMap[key] += "(mehrdeutig)"
		}
		
		bkMap
	}
	
	static List getBanken(Map params) {
		List <Bank> bankList = []
		def RestBuilder rest = new RestBuilder()
		RestResponse resp
		if (params.ort)
			resp = rest.get("${Holders.config.bicService}/bankIdentCode/get?ort=${params.ort}")
		if (params.blz && params.blz != '0') 
			resp = rest.get("${Holders.config.bicService}/bankIdentCode/get?blz=${params.blz}")
		if (params.plz && params.plz != '0') 
			resp = rest.get("${Holders.config.bicService}/bankIdentCode/get?plz=${params.plz}")
		if (params.bic)
			resp = rest.get("${Holders.config.bicService}/bankIdentCode/get?bic=${params.bic}")
		if (params.bankname)
			resp = rest.get("${Holders.config.bicService}/bankIdentCode/get?bankname=${params.bankname}")
		
			
		JSONArray array = new JSONArray(resp.text)
		for (int i=0;i<array.length();i++) {
			 Bank b = new Bank()
			 JSONObject jsonObject = array.getJSONObject(i)
			 b.id = jsonObject.getInt("id")
			 b.bankname = jsonObject.getString("bankname") 
			 b.bic = jsonObject.getString("bic")
			 b.blz = jsonObject.getInt("blz")
			 b.plz = jsonObject.getInt("plz")
			 b.ort = jsonObject.getString("ort")
			 bankList << b
		}
		bankList
	}
	
	static Bank getBank (Map params) {
		def RestBuilder rest = new RestBuilder()
		RestResponse resp
		resp = rest.get("${Holders.config.bicService}/bankIdentCode/get?id=${params.id}")
		JSONArray array = new JSONArray(resp.text)
		Bank b = new Bank()
		JSONObject jsonObject = array.getJSONObject(0)
		b.id = jsonObject.getInt("id")
		b.bankname = jsonObject.getString("bankname")
		b.bic = jsonObject.getString("bic")
		b.blz = jsonObject.getInt("blz")
		b.plz = jsonObject.getInt("plz")
		b.ort = jsonObject.getString("ort")
		
		b
	}
	
	static int getBankId (int blz) {
		def RestBuilder rest = new RestBuilder()
		RestResponse resp
		resp = rest.get("${Holders.config.bicService}/bankIdentCode/get?blz=${blz}")
		JSONArray array = new JSONArray(resp.text)
		JSONObject jsonObject = array.getJSONObject(0)
		jsonObject.getInt("id")
	}
	
	List <Bankverbindung> getBankverbindungen() {
		String b = this.blz.toString()
		
		List <Bankverbindung> bvList = 
		Bankverbindung.findAll("from Bankverbindung as bv where substring(bv.iban,5,8) = ${b}")
	}
}
