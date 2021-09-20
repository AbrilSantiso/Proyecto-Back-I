package com.example.ProyectoIntegradorClinica.controller.restcontroller;

import com.example.ProyectoIntegradorClinica.dto.OdontologoDto;
import com.example.ProyectoIntegradorClinica.service.imp.OdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;
    private final Logger logger = Logger.getLogger(OdontologoController.class);

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id){

        logger.debug("Iniciando el método 'buscarPorId");

        if(odontologoService.buscar(id) != null){
            return ResponseEntity.ok(odontologoService.buscar(id));
        }else{

            return ResponseEntity.badRequest().body("No se encontro el odontologo");
        }

    }

    @PostMapping("/nuevo")
    public ResponseEntity<OdontologoDto> crearNuevo(@RequestBody OdontologoDto odontologo){

        logger.debug("Iniciando el método 'crearNuevo (odontologo)'");
        return ResponseEntity.ok(odontologoService.crear(odontologo));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<OdontologoDto> actualizar(@RequestBody OdontologoDto odontologo){

        logger.debug("Iniciando el método 'actualizar(odontologo)'");

        if(odontologo.getId() != null){
            return ResponseEntity.ok(odontologoService.actualizar(odontologo));
        }else{
            return ResponseEntity.badRequest().body(odontologo);
        }
    }

    @DeleteMapping("/eliminarId/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable("id") Integer id){

        logger.debug("Iniciando el método 'eliminarPorId'");

        ResponseEntity<String> response;
        if(odontologoService.buscar(id) != null){
            odontologoService.eliminar(id);
            response = ResponseEntity.ok("Se eliminó el odontólogo con id "+id);
        }else{
            response= ResponseEntity.badRequest().body("No existe el odontologo con el id" + id);
        }
        return response;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<OdontologoDto>> consultarTodos(){
        logger.debug("Iniciando el método 'consultarTodos'");
        return ResponseEntity.ok(odontologoService.consultarTodos());
    }
}
