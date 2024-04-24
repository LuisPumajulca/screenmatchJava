package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula pelicula = new Pelicula("Encanto",2021);
        pelicula.evaluar(9);
        Pelicula segundaPelicula = new Pelicula("Matrix",2019);
        segundaPelicula.evaluar(4);
        var peliculaDeEstreno = new Pelicula("kong",2023);
        peliculaDeEstreno.evaluar(10);
        Serie casaDragon = new Serie("La casa del dragón",2022);

        Pelicula p1 = pelicula;

        List<Titulo> list = new LinkedList<>();
        list.add(pelicula);
        list.add(segundaPelicula);
        list.add(peliculaDeEstreno);
        list.add(casaDragon);

        for (Titulo item: list) {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula peliculaC && peliculaC.getClasificacion() > 1) {
                System.out.println(peliculaC.getClasificacion());
            }
        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penélope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Arin");

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artista ordenada " + listaDeArtistas);

        Collections.sort(list);
        System.out.println("Lista de titulos ordenados: " + list);

        list.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha: " + list);
    }
}
