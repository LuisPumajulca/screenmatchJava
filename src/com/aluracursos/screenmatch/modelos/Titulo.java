package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.excepcion.ErrorConvertirDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean includoEnElPlan;
    private double sumaDeEvaluaciones;
    private int totalDeEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());
        if (miTituloOmdb.runtime().contains("N/A")){
            throw new ErrorConvertirDuracionException("No pude convertir la duracion, " + "porque contiene un N/A");
        }
        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ",""));
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncludoEnElPlan() {
        return includoEnElPlan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncludoEnElPlan(boolean includoEnElPlan) {
        this.includoEnElPlan = includoEnElPlan;
    }

    public double getSumaDeEvaluaciones() {
        return sumaDeEvaluaciones;
    }

    public void setSumaDeEvaluaciones(double sumaDeEvaluaciones) {
        this.sumaDeEvaluaciones = sumaDeEvaluaciones;
    }

    public int getTotalDeEvaluaciones() {
        return totalDeEvaluaciones;
    }

    public void setTotalDeEvaluaciones(int totalDeEvaluaciones) {
        this.totalDeEvaluaciones = totalDeEvaluaciones;
    }

    public void muestraFichaTecnica() {
        System.out.println("Mi pelicula es: " + nombre);
        System.out.println("Su fecha de lanzamiento es: " + fechaDeLanzamiento);
        System.out.println("Tiene una duracion de: " + getDuracionEnMinutos());
    }

    public void evaluar(double nota) {
        sumaDeEvaluaciones += nota;
        totalDeEvaluaciones++;
    }

    public double calculaMedia() {
        return sumaDeEvaluaciones / totalDeEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(nombre= " + nombre +
                ", fechaDeLanzamiento= " + fechaDeLanzamiento
                + ", duracion= " + duracionEnMinutos + ")";
    }
}
