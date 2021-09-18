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

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<OdontologoDto> buscarPorId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(odontologoService.buscar(id));

        /*if(os.buscar(id) != null){
            return ResponseEntity.ok(os.buscar(id));
        }else{
            return ResponseEntity.notFound().build();
        }*/

    }

    @PostMapping("/nuevo")
    public ResponseEntity<OdontologoDto> crearNuevo(@RequestBody OdontologoDto odontologo){
        return ResponseEntity.ok(odontologoService.crear(odontologo));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<OdontologoDto> actualizar(@RequestBody OdontologoDto odontologo){
        if(odontologo.getId() != null){
            return ResponseEntity.ok(odontologoService.actualizar(odontologo));
        }else{
            return ResponseEntity.badRequest().body(odontologo);
        }
    }

    @DeleteMapping("/eliminarId/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable("id") Integer id){
        ResponseEntity<String> response;
        if(odontologoService.buscar(id) != null){
            odontologoService.eliminar(id);
            response = ResponseEntity.ok("Se eliminó el odontólogo con id "+id);
        }else{
            response= ResponseEntity.badRequest().body("error");
        }
        return response;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<OdontologoDto>> consultarTodos(){
        return ResponseEntity.ok(odontologoService.consultarTodos());
    }
}
