package com.example.demo.modelElementCollectionEmbeddable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class PhoneNumberOne {
private String phoneNumber;
@Enumerated(EnumType.STRING)
private PhoneType type;


public PhoneNumberOne() {
	super();
}

public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public PhoneType getType() {
	return type;
}
public void setType(PhoneType type) {
	this.type = type;
}
@Override
public String toString() {
	return "PhoneNumberOne [phoneNumber=" + phoneNumber + ", type=" + type + "]";
}


}
