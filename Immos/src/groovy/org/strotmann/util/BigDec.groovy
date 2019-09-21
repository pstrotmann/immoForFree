package org.strotmann.util

import java.text.DecimalFormat

class BigDec {
	
	static String nk0 (BigDecimal b) {
		BigDecimal bd = b.setScale(0, BigDecimal.ROUND_DOWN)
		new DecimalFormat("###,###,###").format(bd)
	}

}
