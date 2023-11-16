package com.bankduck.confirmarIdentidad.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreguntasService {

    public List<String> ObtenerPreguntas(){
        List<String> preguntas = new ArrayList<>();
        preguntas.add("¿Tuvo una cuenta de ahorros en bancolombia o davivienda en los ultimos 3 años?");
        preguntas.add("¿Tuvo una tarjeta de credito del banco colpatria en el 2015?");
        preguntas.add("¿Accedio a un credito con el banco bancolombia en el 2012?");
        preguntas.add("¿Tiene actualmente una tarjeta de credito visa?");
        preguntas.add("¿Tuvo un perrito de nombre firulais?");

        return preguntas;
    }
}
