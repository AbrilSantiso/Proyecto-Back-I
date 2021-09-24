package com.example.ProyectoIntegradorClinica.controller.restcontroller;

import com.example.ProyectoIntegradorClinica.dto.PacienteDto;
import com.example.ProyectoIntegradorClinica.dto.TurnoDto;
import com.example.ProyectoIntegradorClinica.service.imp.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    TurnoService turnoService;

    private final Logger logger = Logger.getLogger(PacienteController.class);


    @PostMapping("/nuevo")
    public ResponseEntity<TurnoDto> crearNuevoTurno(@RequestBody TurnoDto turno){
        logger.debug("Iniciando el método 'crearNuevo (turno)'");
        return ResponseEntity.ok(turnoService.crear(turno));
    }
}
