package org.strotmann.util

class Datum {
	static int getAktJahr() {
		Calendar cal = Calendar.getInstance()
		cal.setTime(new Date())
		cal.get(Calendar.YEAR)
	}
	
	static Calendar calDatum(Date d){
		Calendar cal = Calendar.getInstance()
		cal.setTime(d)
		cal
	}
	
	static int stunde(Date d) {
		Calendar cal = Calendar.getInstance()
		cal.setTime(d)
		cal.get(Calendar.HOUR)
	}
	
	static Date plusTage (Date d, int i) {
		Calendar cal = Calendar.getInstance()
		cal.setTime(d)
		cal.add(Calendar.DAY_OF_YEAR, i)
		cal.getTime()
	}
}
