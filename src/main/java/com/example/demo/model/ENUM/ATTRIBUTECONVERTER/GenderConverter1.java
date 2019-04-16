package com.example.demo.model.ENUM.ATTRIBUTECONVERTER;

import javax.persistence.AttributeConverter;

public class GenderConverter1 implements AttributeConverter<Gender, Character>{

	@Override
	public Character convertToDatabaseColumn(Gender attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gender convertToEntityAttribute(Character dbData) {
		// TODO Auto-generated method stub
		return null;
	}

}
