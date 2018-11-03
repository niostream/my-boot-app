package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "mydata")
@Data
public class MyData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@NotNull
	private long id;
	
	@Column(length = 50, nullable = false)
	@NotEmpty(message = "空白は不可")
	private String name;
	
	@Column(length = 200, nullable = true)
	@Email(message = "メールアドレスのみ")
	private String mail;
	
	@Column(nullable = true)
	@Min(value = 0, message = "0以上")
	@Max(value = 200, message = "200以下")
	private Integer age;
	
	@Column(nullable = true)
	private String memo;

}
