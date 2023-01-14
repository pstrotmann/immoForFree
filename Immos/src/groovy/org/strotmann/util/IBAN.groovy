package org.strotmann.util

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
		
		String accountNumber
		
		int j = ktoNr.length()
		switch (j) {
			case 10: accountNumber = ktoNr; break 
			case  9: accountNumber = "0" + ktoNr; break
			case  8: accountNumber = "00" + ktoNr; break
			case  7: accountNumber = "000" + ktoNr; break
		}		
		
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
}
