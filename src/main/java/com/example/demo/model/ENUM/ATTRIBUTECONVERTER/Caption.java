package com.example.demo.model.ENUM.ATTRIBUTECONVERTER;

public class Caption {
	private String text;

	public Caption(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		return text!=null ?text.hashCode():0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caption other = (Caption) obj;
		return text!=null?text.equals(other.getText()):other.text==null;
	}

	@Override
	public String toString() {
		return "Caption [text=" + text + "]";
	}
	
}
