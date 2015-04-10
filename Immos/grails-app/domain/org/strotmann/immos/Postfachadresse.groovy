package org.strotmann.immos

class Postfachadresse extends Adresse {
	
    int postfach
	
	static belongsTo = [organisation:Organisation]
    
	static constraints = {
		postfach(nullable:true)
		postleitzahl (min:1000, max:99999,unique:['postfach','organisation'])
    	ort (maxLength:30, blank:false)
    }
    
    String toString() {
		if (this.postfach > 0)
			return "${this.postfach}  , ${this.postleitzahl}  ${this.ort}"
		else
			return "${this.postleitzahl}  ${this.ort}"
	}
}
