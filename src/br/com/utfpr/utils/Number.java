package br.com.utfpr.utils;

public final class Number {

	public static boolean isNumber(String str) {
	    return str.matches("^[0-9]+(\\.[0-9]+)?$");
	}
}
