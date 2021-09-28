package com.example.ProyectoIntegradorClinica.controller.restcontroller;

import com.example.ProyectoIntegradorClinica.dto.TurnoDto;
import com.example.ProyectoIntegradorClinica.service.imp.TurnoService;
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


    @GetMapping("/todos")
    public ResponseEntity<List<TurnoDto>> consultarTodos() {
        logger.debug("Iniciando el método 'consultarTodos'");
        return ResponseEntity.ok(turnoService.consultarTodos());
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id){

        logger.debug("Iniciando el método 'buscarPorId");

        if(turnoService.buscar(id) != null){
            logger.debug("Se encontro el turno");
            return ResponseEntity.ok(turnoService.buscar(id));

        }else{
            logger.debug("No se encontro el turno");
            return ResponseEntity.badRequest().body("No se encontro el turno");
        }

    }

    @GetMapping("/proximaSemana")
    public ResponseEntity<List<TurnoDto>> consultarProximosTurnos() {
        logger.debug("Iniciando el método 'consultarProximosTurnos'");
        return ResponseEntity.ok(turnoService.consultarProximosTurnos());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<TurnoDto> crearNuevoTurno(@RequestBody TurnoDto turno){
        logger.debug("Iniciando el método 'crearNuevo (turno)'");
        return ResponseEntity.ok(turnoService.crear(turno));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarTurno(@RequestBody TurnoDto turno){

        logger.debug("Iniciando el método 'actualizar(turno)'");

        if(turno.getId() != null) {
            logger.debug("Se pudo actualizar el turno");
            return ResponseEntity.ok(turnoService.actualizar(turno));
        }else{
            logger.debug("No se pudo actualizar el turno");
            return ResponseEntity.badRequest().body("No se pudo actualizar el turno porque no es valido");
        }

    }

    @DeleteMapping("/eliminarId/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable("id") Integer id){

        logger.debug("Iniciando el método 'eliminarPorId'");

        ResponseEntity<String> response;
        if(turnoService.buscar(id) != null){
         turnoService.eliminar(id);
            response = ResponseEntity.ok("Se eliminó el turno con id "+id);
            logger.debug("Se eliminó el turno con id "+id);
        }else{
            response= ResponseEntity.badRequest().body("No se encontro el turno");
            logger.debug("No se encontro el turno con id "+id);
        }
        return response;
    }
}
