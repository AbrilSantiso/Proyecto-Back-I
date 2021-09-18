package com.example.ProyectoIntegradorClinica.persistence.repository;


import com.example.ProyectoIntegradorClinica.persistence.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer > {
}
