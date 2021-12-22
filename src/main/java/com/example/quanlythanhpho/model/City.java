package com.example.quanlythanhpho.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne( targetEntity = Country.class)
    @JoinColumn(name = "country_id")
    private Country country;
    private Double area;
    private Long people;
    private String gdp;
    private String description;


}
