package com.example.ProyectoIntegradorClinica.controller.restcontroller;


import com.example.ProyectoIntegradorClinica.dto.PacienteDto;
import com.example.ProyectoIntegradorClinica.service.imp.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    private final Logger logger = Logger.getLogger(PacienteController.class);

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id){

        logger.debug("Iniciando el método 'buscarPorId");

        if(pacienteService.buscar(id) != null){
            logger.debug("Se encontro el paciente");
            return ResponseEntity.ok(pacienteService.buscar(id));

        }else{
            logger.debug("No se encontro el paciente");
            return ResponseEntity.badRequest().body("No se encontro el paciente");
        }

    }

    @GetMapping("/todos")
    public ResponseEntity<List<PacienteDto>> consultarTodos() {
        logger.debug("Iniciando el método 'consultarTodos'");
        return ResponseEntity.ok(pacienteService.consultarTodos());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<PacienteDto> crearNuevoPaciente(@RequestBody PacienteDto paciente){
        logger.debug("Iniciando el método 'crearNuevo (paciente)'");
        return ResponseEntity.ok(pacienteService.crear(paciente));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<PacienteDto> actualizarPaciente(@RequestBody PacienteDto paciente){

        logger.debug("Iniciando el método 'actualizar(odontologo)'");

        if(paciente.getId() != null) {
            logger.debug("Se pudo actualizar el paciente");
            return ResponseEntity.ok(pacienteService.actualizar(paciente));
        }else{
            logger.debug("No se pudo actualizar el paciente");
            return ResponseEntity.badRequest().body(paciente);
        }

    }

    @DeleteMapping("/eliminarId/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable("id") Integer id){

        logger.debug("Iniciando el método 'eliminarPorId'");
        
        ResponseEntity<String> response;
        if(pacienteService.buscar(id) != null){
          pacienteService.eliminar(id);
            response = ResponseEntity.ok("Se eliminó el paciente con id "+id);
            logger.debug("Se eliminó el paciente con id "+id);
        }else{
            response= ResponseEntity.badRequest().body("No se encontro el paciente");
            logger.debug("No se encontro el paciente con id "+id);
        }
        return response;
    }

}
