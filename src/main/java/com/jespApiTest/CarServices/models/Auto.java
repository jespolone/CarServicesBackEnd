package com.jespApiTest.CarServices.models;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="auto")
public class Auto implements Serializable{

	private static final long serialVersionUID = 5116378874529338768L;
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

	@Column(name="proprietario")
	private long idProprietario;
}
