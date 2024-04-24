package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula pelicula = new Pelicula("Encanto",2021);
        pelicula.setDuracionEnMinutos(120);
        pelicula.setIncludoEnElPlan(true);

        pelicula.muestraFichaTecnica();
        pelicula.evaluar(7.8);
        pelicula.evaluar(10);
        pelicula.evaluar(8);

        System.out.println(pelicula.getTotalDeEvaluaciones());
        System.out.println(pelicula.calculaMedia());

        Serie casaDragon = new Serie("La casa del dragón",2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodios(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        Pelicula segundaPelicula = new Pelicula("Matrix",2019);

        segundaPelicula.setDuracionEnMinutos(180);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(pelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(segundaPelicula);
        System.out.println("Tiempo necesario para ver tus titulos favoritos "+calculadora.getTiempoTotal());


        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(pelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa Targaryan");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(500);
        filtroRecomendacion.filtra(episodio);

        var peliculaDeEstreno = new Pelicula("kong",2023);
        peliculaDeEstreno.setDuracionEnMinutos(180);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(pelicula);
        listaDePeliculas.add(segundaPelicula);
        listaDePeliculas.add(peliculaDeEstreno);

        System.out.println("Tamaño de la lista: " + listaDePeliculas.size() );
        System.out.println("Tamaño de la lista: " + listaDePeliculas.get(0).getNombre());

        System.out.println(listaDePeliculas);
        System.out.println("toString de lña pelicula: " + listaDePeliculas.get(0).toString());

    }
}
