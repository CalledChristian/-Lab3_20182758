package com.example.demo.hospital;

import com.example.demo.doctor.Doctor;
import com.example.demo.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {

    //NOTAS:
    //Por el momento para el Query , solo podemos usar Select * From (tabla)
    //El repositorio Hospital , solo puede guardar elementos de clase Hospital

    @Query(value="select * from hospital where id= ?1 ",nativeQuery = true)
    Hospital hospitalDeDoctor(int idHospital);

    @Query(value="select * from hospital where id= ?1 ",nativeQuery = true)
    Hospital hospitalDePaciente (int idHospital);

}