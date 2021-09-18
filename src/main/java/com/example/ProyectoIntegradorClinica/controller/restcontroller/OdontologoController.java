package com.example.ProyectoIntegradorClinica.controller.restcontroller;

import com.example.ProyectoIntegradorClinica.dto.OdontologoDto;
import com.example.ProyectoIntegradorClinica.service.imp.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;

    @GetMapping("/listar")
    public ResponseEntity<List<OdontologoDto>> getAll() {
        return ResponseEntity.ok(odontologoService.consultarTodos());
    }

    @PostMapping("/nuevo")
    public ResponseEntity<OdontologoDto> crearNuevoPaciente(@RequestBody OdontologoDto o){
        return ResponseEntity.ok(odontologoService.crear(o));
    }

   /* @PutMapping("/actualizar")
    public ResponseEntity<PacienteDto> actualizarPaciente(@RequestBody PacienteDto paciente){
        if(paciente.getId() != null) {
            return ResponseEntity.ok(pacienteService.actualizar(paciente));
        }else{
            return ResponseEntity.badRequest().body(paciente);
        }
    }*/
}
