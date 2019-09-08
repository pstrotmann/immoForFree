package org.strotmann.util

import java.util.List;

class JahrSel {
	long id
	int selektor
	
	JahrSel (id, selektor) {
		this.id = id
		this.selektor = selektor
	}
	
	String toString() {"${selektor}"}
	
	static getJahr (List <JahrSel> j, String i) {
		JahrSel jahr
		j.each{JahrSel js ->
			if (js.id == i.toLong())
				jahr = js
		}
		jahr
	}
}
