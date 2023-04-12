package com.example.demo.hospital;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //porque es autoincremental
    @Column(name="id",nullable = false)
    private Integer idHospital;
    @Column(name="nombre",nullable = false,length = 50)
    private String nombre;
    @Column(name="direccion",nullable = false, length = 100)
    private String direccion;
    @Column(name="telefono",nullable = false, length = 45)
    private String telefono;

}