package com.jespApiTest.CarServices.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
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

    @Column(name="startdate")
    private Timestamp  startdate;
    //MySQL Format: 2003-12-31 23:59:59

    @Column(name="enddate")
    private Timestamp enddate;

    @Column(name="datedescription")
    private String datedescription;

    @Column(name="dayid")
    private String dayid;

    @JoinColumn(name = "client", nullable = false)
    private Integer client;


    @JoinColumn(name = "mechanic", nullable = false)
    private Integer mechanic;


    @JoinColumn(name = "auto ", nullable = false)
    private Integer auto;

}

