package com.jespApiTest.CarServices.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -7978044467188208581L;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="cognome")
    private String cognome;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="isactive")
    private int isactive;

    //Valore settato di default per la creazione di una risorsa di tipo impiegato
    @Column(name = "ruolo")
    private int idRuolo;

    @Column(name = "code")
    private  int code;

//    @JsonProperty( access = JsonProperty.Access.READ_ONLY)
//    @ManyToOne
//    @JoinColumn(name="ruolo", insertable = false, updatable = false)
//    private Role role;

//    @ManyToMany
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @JoinTable(name = "utente_attivita", joinColumns = {@JoinColumn(name = "id_utente")}, inverseJoinColumns = {@JoinColumn(name = "id_attivita")})
//    private List<Attivita> attivita = new ArrayList<>();

}
