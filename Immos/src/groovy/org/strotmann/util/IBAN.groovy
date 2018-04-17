package org.strotmann.util

class IBAN {
	
	static String ibanForm(String i) {
		"${i.substring(0,4)} ${i.substring(4,8)} ${i.substring(8,12)} ${i.substring(12,16)} ${i.substring(16,20)} ${i.substring(20,22)}"
	}
	
	static String ibanRein(String i) {
		"${i.replaceAll(" ", "")}"
	}
}
