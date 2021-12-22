package com.example.test.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cityName;
    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;

    private double area;
    private int population;
    private double gdp;
    private String description;

}
