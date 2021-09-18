package com.example.ProyectoIntegradorClinica.service.imp;

import com.example.ProyectoIntegradorClinica.dto.OdontologoDto;
import com.example.ProyectoIntegradorClinica.persistence.entities.Odontologo;
import com.example.ProyectoIntegradorClinica.persistence.repository.IOdontologoRepository;
import com.example.ProyectoIntegradorClinica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements IService<OdontologoDto> {

    @Autowired
     IOdontologoRepository repository;

    @Override
    public OdontologoDto buscar(Integer id) {
        OdontologoDto o = new OdontologoDto(repository.getById(id));
       return o;
    }

    @Override
    public OdontologoDto crear(OdontologoDto odontologoDto) {
        Odontologo o = odontologoDto.toEntity();
        repository.save(o);
        odontologoDto.setId(o.getId());
        return odontologoDto;
    }

    @Override
    public OdontologoDto actualizar(OdontologoDto odontologoDto) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<OdontologoDto> consultarTodos() {
        return null;
    }
}
