package com.example.demo.model.ENUM.ATTRIBUTECONVERTER;

public enum Gender {
	MALE('M'), 
	FEMALE('F');
	
	private final char code;
	private Gender(char code) {
		this.code = code;
	}
	public static Gender fromCode(char code) {
		if(code=='M' || code=='m') {
			return MALE;
		}
		if(code=='f'|| code=='F') {
			return FEMALE;
		}
		throw new UnsupportedOperationException(  "The code " + code + " is not supported!");
	}
	public char getCode() {
		return code;
	}

}
