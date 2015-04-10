package immos

class SimpleTagLib {
	def emoticon = { attrs, body ->
		out << body() << (attrs.happy == 'true' ? " :-)" : " :-(")
	 }
}
