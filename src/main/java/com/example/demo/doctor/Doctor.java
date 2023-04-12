package com.example.demo.doctor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //porque es autoincremental
    @Column(name = "id", nullable = false)
    private Integer idDoctor;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "especialidad", nullable = false, length = 50)
    private String especialidad;
    @Column(name = "hospital_id", nullable = false)
    private Integer idHospital;
}