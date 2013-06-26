package br.com.utfpr.core.parser;

import java.util.logging.Logger;

public class PrefixParser extends Parser implements IParser {

	private final static Logger LOGGER = Logger.getLogger(PrefixParser.class.getName());
	

	
	public String toString(){
		return "PrefixParser";
	}
	
	// Convert infix expression format into Polish notation
	@Override
	public String[] parse(String input) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
}
