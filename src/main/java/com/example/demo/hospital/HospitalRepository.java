package com.example.demo.hospital;

import com.example.demo.doctor.Doctor;
import com.example.demo.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {

    @Query(value="select d.id,d.nombre,d.especialidad from doctor d left join hospital h on (d.hospital_id = h.id) where h.id= ?1 ",nativeQuery = true)
    List<Doctor> buscarDoctorPorHospital (int idHospital);

    @Query(value="select nombre,edad,genero,diagnostico,fecha_cita,numero_habitacion from paciente where hospital_id= ?1 ",nativeQuery = true)
    List<Paciente> buscarPacientePorHospital (int idHospital);
}