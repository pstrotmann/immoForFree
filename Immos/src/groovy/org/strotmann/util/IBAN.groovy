package org.strotmann.util

class IBAN {
	String ibanAufb(String i) {
		"${i.substring(0,4)} ${i.substring(4,8)} ${i.substring(8,12)} ${i.substring(12,16)} ${i.substring(16,20)} ${i.substring(20,22)}"
	}
}
