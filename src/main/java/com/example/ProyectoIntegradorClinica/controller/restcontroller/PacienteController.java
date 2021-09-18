package com.example.ProyectoIntegradorClinica.controller.restcontroller;


import com.example.ProyectoIntegradorClinica.dto.PacienteDto;
import com.example.ProyectoIntegradorClinica.service.imp.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id){

        if(pacienteService.buscar(id) != null){
            return ResponseEntity.ok(pacienteService.buscar(id));
        }else{
            return ResponseEntity.badRequest().body("No se encontro el paciente");
        }

    }

    @GetMapping("/todos")
    public ResponseEntity<List<PacienteDto>> getAll() {
        return ResponseEntity.ok(pacienteService.consultarTodos());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<PacienteDto> crearNuevoPaciente(@RequestBody PacienteDto paciente){
        return ResponseEntity.ok(pacienteService.crear(paciente));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<PacienteDto> actualizarPaciente(@RequestBody PacienteDto paciente){
        if(paciente.getId() != null) {
            return ResponseEntity.ok(pacienteService.actualizar(paciente));
        }else{
            return ResponseEntity.badRequest().body(paciente);
        }

    }

    @DeleteMapping("/eliminarId/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable("id") Integer id){
        ResponseEntity<String> response;
        if(pacienteService.buscar(id) != null){
          pacienteService.eliminar(id);
            response = ResponseEntity.ok("Se eliminó el paciente con id "+id);
        }else{
            response= ResponseEntity.badRequest().body("No se encontro el paciente");
        }
        return response;
    }

}
