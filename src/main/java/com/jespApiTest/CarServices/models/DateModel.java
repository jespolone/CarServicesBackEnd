package com.jespApiTest.CarServices.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import java.util.Date;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 *
 * Model
 *
 * @author Elvin Iluca
 *
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="date")
public class DateModel {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private int id;

    @Column(name="date")
    private Timestamp  date;
    //MySQL Format: 2003-12-31 23:59:59


    @OneToOne
    @JoinColumn(name = "client", nullable = false)
    private User client;

    @OneToOne
    @JoinColumn(name = "mechanic", nullable = false)
    private User mechanic;

}

