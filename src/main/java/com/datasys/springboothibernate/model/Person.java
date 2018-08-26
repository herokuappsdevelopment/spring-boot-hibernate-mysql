package com.datasys.springboothibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty
	private int id;
	
	@JsonProperty
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/mm/yyyy")
	private Date dob;
	
}
