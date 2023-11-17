package com.bankduck.confirmarIdentidad.controller;

import com.bankduck.confirmarIdentidad.services.CodigoVerificacionService;
import com.bankduck.confirmarIdentidad.services.PreguntasService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "Api confirmar identidad personas")
@RestController
@RequestMapping("/confirmarIdentidad")
public class ApiRestController {

    @Autowired
    PreguntasService preguntasService;
    @Autowired
    CodigoVerificacionService codigoVerificacionService;
    @PostMapping("/{cedula}")
    public ResponseEntity<String> post(@PathVariable String cedula) {
        codigoVerificacionService.generarCodigo(cedula);
        return new ResponseEntity<String>("Identidad verificada", HttpStatus.OK);
    }

    @GetMapping("/obtenerPreguntas/{cedula}")
    public List<String> list(@PathVariable String cedula) {
        List<String> preguntas = preguntasService.ObtenerPreguntas();
        return preguntas;
    }

}
