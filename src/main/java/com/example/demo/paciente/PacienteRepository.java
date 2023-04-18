package com.example.demo.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    @Query(value="select * from paciente where hospital_id= ?1 ",nativeQuery = true)
    List<Paciente> buscarPacientePorHospital (int idHospital);


    @Query(value="select * from paciente where doctor_id = ?1 ",nativeQuery = true)
    List<Paciente> buscarPacientePorDoctor (int idDoctor);

    @Query(value="select * from paciente where fecha_cita > 2023-04-11 and doctor_id= ?1",nativeQuery = true)
    List<Paciente> buscarProximasCitas (int idDoctor);

    @Modifying
    @Query(value="update paciente set numero_habitacion = ?1 where id= ?2 ",nativeQuery = true)
    void actualizarHabitacion (int nrohabitacion,int idPaciente);
}
