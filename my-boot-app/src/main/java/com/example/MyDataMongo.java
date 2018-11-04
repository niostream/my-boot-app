package com.example;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class MyDataMongo {
	
	@Id
	private String id;
	
	private String name;
	
	private String memo;
	
	private Date date;
	
	public MyDataMongo(String name, String memo) {
		super();
		this.name = name;
		this.memo = memo;
		this.date = new Date();
	}

}
