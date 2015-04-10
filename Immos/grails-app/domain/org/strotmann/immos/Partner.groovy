package org.strotmann.immos

import java.util.SortedSet;

class Partner implements Comparable {
	 
	String name
	
	Hausadresse hausadresse 
	
	SortedSet partnerrolle
	static hasMany = [kommunikation:Kommunikation,
						bankverbindung:Bankverbindung,
						partnerrolle:Partnerrolle]
	
	static mapping = {
		tablePerHierarchy false
	}
		
	static constraints = {
		name()
		hausadresse (nullable:true)
	}
	
	String toString() {"${this.name}" }
	
	int compareTo(obj) {
		name.compareTo(obj.name)
	}
}
