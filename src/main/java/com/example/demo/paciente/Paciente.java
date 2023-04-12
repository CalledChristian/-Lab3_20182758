package com.example.demo.paciente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name="paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //porque es autoincremental
    @Column(name = "id", nullable = false)
    private Integer idPaciente;
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Column(name = "edad", nullable = false)
    private Integer edad;
    @Column(name = "genero", nullable = false, length = 45)
    private String genero;
    @Column(name = "diagnostico", nullable = false, length = 100)
    private String diagnostico;
    @Column(name = "fecha_cita", nullable = false)
    private Date fechaCita;
    @Column(name = "numero_habitacion", nullable = false)
    private Integer numHabitacion;
    @Column(name = "doctor_id", nullable = false)
    private Integer idDoctor;
    @Column(name = "hospital_id", nullable = false)
    private Integer idHospital;
}


