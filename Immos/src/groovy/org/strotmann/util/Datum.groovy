package org.strotmann.util

class Datum {
	static int getAktJahr() {
		Calendar cal = Calendar.getInstance()
		cal.setTime(new Date())
		cal.get(Calendar.YEAR)
	}
}
