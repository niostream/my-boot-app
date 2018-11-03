package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "msgdata")
@Data
public class MsgData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@NotNull
	private long id;
	
	@Column
	private String title;
	
	@Column(nullable = false)
	@NotEmpty
	private String message;
	
	@ManyToOne
	private MyData myData;
	
	public MsgData() {
		super();
		this.myData = new MyData();
	}

}
