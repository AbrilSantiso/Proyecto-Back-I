package com.example.ProyectoIntegradorClinica.controller.restcontroller;

import com.example.ProyectoIntegradorClinica.dto.TurnoDto;
import com.example.ProyectoIntegradorClinica.exceptions.BadRequestException;
import com.example.ProyectoIntegradorClinica.exceptions.ResourceNotFoundException;
import com.example.ProyectoIntegradorClinica.service.imp.TurnoService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    TurnoService turnoService;

    private final Logger logger = Logger.getLogger(PacienteController.class);

    @Operation(summary = "Este método trae todos los turnos de la base de datos", tags = "Turnos")
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/todos")
    public ResponseEntity<List<TurnoDto>> consultarTodos() {
        logger.debug("Iniciando el método 'consultarTodos'");
        return ResponseEntity.ok(turnoService.consultarTodos());
    }

    @Operation(summary = "Este método trae el turno con el id especificado en la url", tags = "Turnos")
    @GetMapping("/buscarId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id) throws ResourceNotFoundException {

        logger.debug("Iniciando el método 'buscarPorId");

        if(turnoService.buscar(id) != null){
            logger.debug("Se encontro el turno");
            return ResponseEntity.ok(turnoService.buscar(id));

        }else{
            logger.debug("No se encontro el turno");
            throw new ResourceNotFoundException("No se encontro el turno");
        }

    }
    @Operation(summary = "Este método trae todos los turnos de la proxima semana (desde el dia actual, sumandole 7 dias) de la base de datos", tags = "Turnos")
    @GetMapping("/proximaSemana")
    public ResponseEntity<List<TurnoDto>> consultarProximosTurnos() {
        logger.debug("Iniciando el método 'consultarProximosTurnos'");
        return ResponseEntity.ok(turnoService.consultarProximosTurnos());
    }

    @Operation(summary = "Este método registra un nuevo turno", tags = "Turnos")
    @PostMapping("/nuevo")
    public ResponseEntity<TurnoDto> crearNuevoTurno(@RequestBody TurnoDto turno){
        logger.debug("Iniciando el método 'crearNuevo (turno)'");
        return ResponseEntity.ok(turnoService.crear(turno));
    }

    @Operation(summary = "Este método actualiza un turno existente", tags = "Turnos")
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarTurno(@RequestBody TurnoDto turno) throws BadRequestException, ResourceNotFoundException {

        logger.debug("Iniciando el método 'actualizar(turno)'");

        if (turno.getId() == null) {
            throw new BadRequestException("Es necesario el id del turno");
        } else {
            if (turnoService.buscar(turno.getId()) != null) {
                logger.debug("Se pudo actualizar el turno");
                return ResponseEntity.ok(turnoService.actualizar(turno));
            } else {
                throw new ResourceNotFoundException("No se encontro el turno con el id " + turno.getId());
            }
        }

    }

    @Operation(summary = "Este método elimina el turno con el id especificado en la url", tags = "Turnos")
    @DeleteMapping("/eliminarId/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable("id") Integer id) throws ResourceNotFoundException {

        logger.debug("Iniciando el método 'eliminarPorId'");

        if(turnoService.buscar(id) != null){
            turnoService.eliminar(id);
            logger.debug("Se eliminó el turno con id "+id);
            return ResponseEntity.ok("Se eliminó el turno con id "+id);
        }else{
            logger.debug("No se encontro el turno con id "+id);
            throw new ResourceNotFoundException("No se encontro el turno con el id " + id);
        }
    }
}
