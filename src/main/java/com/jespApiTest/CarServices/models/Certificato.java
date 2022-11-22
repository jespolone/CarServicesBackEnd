package com.jespApiTest.CarServices.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="certificato")
public class Certificato {
	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Column(name="id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="id_auto", insertable=false, updatable=false)
	private Auto auto;
	
	@Column(name="anno")
	private int anno;

}
