package com.example.demo.doctor;

import com.example.demo.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {


    @Query(value="select * from doctor where hospital_id= ?1 ",nativeQuery = true)
    List<Doctor> buscarDoctorPorHospital (int idHospital);

    @Query(value="select * from doctor where id= ?1 ",nativeQuery = true)
    Doctor doctorDePaciente (int idDoctor);






}
