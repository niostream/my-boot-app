package com.example;

public class DataObject {
	
	private int id;
	
	private String name;
	
	private String value;
	
	public DataObject(int id, String name, String value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
	
}
