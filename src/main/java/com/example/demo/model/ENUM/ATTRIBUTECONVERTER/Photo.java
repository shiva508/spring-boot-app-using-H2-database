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
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	@Convert(converter=CaptionConverter.class)
	private Caption caption;
	
	@Override
	public String toString() {
		return "Photo [id=" + id + ", name=" + name + ", caption=" + caption + "]";
	}

	@Converter
	public static class CaptionConverter implements AttributeConverter<Caption, String>{
		@Override
		public String convertToDatabaseColumn(Caption attribute) {
			return attribute.getText();
		}

		@Override
		public Caption convertToEntityAttribute(String dbData) {
			return new Caption(dbData);
		}
	}
}
