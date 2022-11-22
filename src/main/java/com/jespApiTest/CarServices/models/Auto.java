package com.jespApiTest.CarServices.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="auto")
public class Auto {
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	private int id;
	
	@Column(name="modello")
	private String modello;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="targa")
	private String targa;
	
	@Column(name="colore")
	private String colore;
	
	@Column(name="anno")
	private int anno;
}
