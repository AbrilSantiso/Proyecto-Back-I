package com.example.ProyectoIntegradorClinica.service.imp;

import com.example.ProyectoIntegradorClinica.dto.TurnoDto;
import com.example.ProyectoIntegradorClinica.persistence.entities.Paciente;
import com.example.ProyectoIntegradorClinica.persistence.entities.Turno;
import com.example.ProyectoIntegradorClinica.persistence.repository.IPacienteRepository;
import com.example.ProyectoIntegradorClinica.persistence.repository.ITurnoRepository;
import com.example.ProyectoIntegradorClinica.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TurnoService implements IService<TurnoDto> {


    @Autowired
    ITurnoRepository repository;

    @Autowired
    OdontologoService serviceOdontologo;

    @Autowired
    PacienteService servicePaciente;

    @Override
    public TurnoDto buscar(Integer id) {
        return null;
    }


    @Override
    public TurnoDto actualizar(TurnoDto turnoDto) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<TurnoDto> consultarTodos() {
        List<TurnoDto> turnos = new ArrayList<>();

        for(Turno t : repository.findAll()){
            turnos.add(new TurnoDto(t));
        }

        return turnos;
    }

    @Override
    public TurnoDto crear(TurnoDto turnoDto) {

        Integer pacienteId = turnoDto.getPaciente().getId();
        Integer odontologoId = turnoDto.getOdontologo().getId();

        if(this.verficarTurno(pacienteId,odontologoId,turnoDto.getFechaYHora()) && this.verificarQueNoExisteElTurno(turnoDto)){
            turnoDto.setPaciente(servicePaciente.buscar(pacienteId));
            turnoDto.setOdontologo(serviceOdontologo.buscar(odontologoId));
            Turno turnoGuardado = repository.save(turnoDto.toEntity());
            turnoDto.setId(turnoGuardado.getId());

            return turnoDto;
        }else{
            //Exception ("El odontólogo y/o el paciente no existen")
           return null;
        }
    }

    private boolean verficarTurno(Integer pacienteId, Integer odontologoId, LocalDateTime fechaYHora){

        return (servicePaciente.buscar(pacienteId) != null && servicePaciente.buscar(odontologoId) !=null && fechaYHora != null);

    }

    private boolean verificarQueNoExisteElTurno(TurnoDto turnoNuevo){
        boolean check = true;
        for (TurnoDto turno: this.consultarTodos()) {
             if(turno.equals(turnoNuevo)){
                return check = false;
             }
        }
        return check;
    }

}
