package com.todocodeacademy.notas_escolares.service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlumnoService {

    private List<Double> listaNotas = List.of(8.0,7.0,6.0,5.0,10.0,9.0,5.0,7.0,9.0);

    public List<Double> getNotas(){
        return this.listaNotas;
    }

    public Double getPromedio(){
        Double promedio;
        Double sumaNotas = 0.0;

        for(Double nota : this.listaNotas){
            sumaNotas += nota;
        }

        return (sumaNotas/listaNotas.size());
    }
}
