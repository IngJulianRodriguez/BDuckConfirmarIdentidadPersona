package com.bankduck.confirmarIdentidad.controller;

import com.bankduck.confirmarIdentidad.services.CodigoVerificacionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Api(tags = "Api confirmar identidad personas")
@RestController
@RequestMapping("/confirmarIdentidad")
public class ApiRestController {

    @Autowired
    CodigoVerificacionService codigoVerificacionService;
    @PostMapping("/{cedula}")
    public ResponseEntity<String> post(@PathVariable String cedula) {
        Long longCedula = Long.parseLong(cedula);
        codigoVerificacionService.generarCodigo(longCedula);
        return new ResponseEntity<String>("Identidad verificada", HttpStatus.OK);
    }

    @GetMapping("/obtenerPreguntas/{cedula}")
    public List<String> list(@PathVariable String cedula) {
        List<String> preguntas = new ArrayList<>();
        preguntas.add("¿Tuvo una cuenta de ahorros en bancolombia o davivienda en los ultimos 3 años?");
        preguntas.add("¿Tuvo una tarjeta de credito del banco colpatria en el 2015?");
        preguntas.add("¿Accedio a un credito con el banco bancolombia en el 2012?");
        preguntas.add("¿Tiene actualmente una tarjeta de credito visa?");
        preguntas.add("¿Tuvo un perrito de nombre firulais?");

        return preguntas;
    }

}
