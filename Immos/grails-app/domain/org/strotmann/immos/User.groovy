package org.strotmann.immos

class User {
	
	String name
	String passwort

    static constraints = {
		name(unique:true)
		passwort()
    }
}
