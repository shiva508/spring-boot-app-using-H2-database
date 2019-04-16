package com.example.demo.model.ENUM.ATTRIBUTECONVERTER;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class PersonENUM {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
private Integer id;
private String name;
@Convert(converter=GenderConverter.class)
private Gender gender;


@Override
public String toString() {
	return "PersonENUM [id=" + id + ", name=" + name + ", gender=" + gender + "]";
}


@Converter
public static class GenderConverter
		implements AttributeConverter<Gender, Character> {

	public Character convertToDatabaseColumn( Gender value ) {
		if ( value == null ) {
			return null;
		}

		return value.getCode();
	}

	public Gender convertToEntityAttribute( Character value ) {
		if ( value == null ) {
			return null;
		}

		return Gender.fromCode( value );
	}
}
}

