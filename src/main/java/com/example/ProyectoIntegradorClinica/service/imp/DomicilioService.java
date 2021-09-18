package com.example.ProyectoIntegradorClinica.service.imp;

import com.example.ProyectoIntegradorClinica.dto.DomicilioDto;
import com.example.ProyectoIntegradorClinica.persistence.repository.IDomiclioRepository;
import com.example.ProyectoIntegradorClinica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService implements IService<DomicilioDto> {

    @Autowired
    IDomiclioRepository repository;

    //No vamos a manejar directamente los metodos de Domicilio, solo el de actualizar que lo necesitamos para actualizar el paciente
    @Override
    public DomicilioDto buscar(Integer id) {
        return null;
    }

    @Override
    public DomicilioDto crear(DomicilioDto domicilioDto) {
        return null;
    }

    @Override
    public DomicilioDto actualizar(DomicilioDto domicilioDto) {
        repository.save(domicilioDto.toEntity());
        return domicilioDto;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<DomicilioDto> consultarTodos() {
        return null;
    }
}
