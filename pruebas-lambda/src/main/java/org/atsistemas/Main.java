package org.atsistemas;

import org.atsistemas.entidades.Pelicula;
import org.atsistemas.interfaces.InterfazLambda;
import org.atsistemas.repositorio.PeliculaRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        // Lambda para cada operación
        InterfazLambda suma = (i, j) -> { return i+j;};
        InterfazLambda resta = (i, j) -> { return i-j;};
        InterfazLambda division = (i, j) -> { return i/j;};
        InterfazLambda multiplicacion = (i, j) -> { return i*j;};


        // Mostrando por pantalla
        System.out.println(suma.calculadora(4,5));
        System.out.println(resta.calculadora(4,5));
        System.out.println(division.calculadora(10,5));
        System.out.println(multiplicacion.calculadora(4,5));

       PeliculaRepository peliculaRepository = new PeliculaRepository();
       Collection<Pelicula> peliculas =  peliculaRepository.obtenerPeliculas();

        //Comprobando si existe alguna película de Accion
        boolean verdadero = peliculas.stream().map(Pelicula::getGenero).anyMatch("Accion"::equals);
        System.out.println(verdadero);

        //Contar peliculas del siglo pasado
        Long numeroPeliculas = peliculas.stream().filter(Pelicula -> Pelicula.getFechaEstreno()<2001).count();
        System.out.println(numeroPeliculas);

        //Obtener el listado de titulos de peliculas
        Collection<String> listado = peliculas.stream()
                .map(Pelicula::getTitulo)
                .collect(Collectors.toList());
        System.out.println(listado);

        //Obtener un listado de películas del siglo pasado ordenadas por titulo
        Collection<Pelicula> listado2 = peliculas.stream()
                .filter(pelicula -> pelicula.getFechaEstreno() < 2000)
                .sorted(Comparator.comparing(Pelicula::getTitulo))
                .collect(Collectors.toList());
        System.out.println(listado2);


        //Obtener la media de edad de las peliculas

        double mediaEdad = peliculas.stream()
                .mapToInt(s->2023-s.getFechaEstreno())
                .average()
                .getAsDouble();
        System.out.println("La media de edad es: "+ mediaEdad);

        //Obtener un mapa con las peliculas agrupadas por genero
        Map<String, List<Pelicula>> peliculasGenero = peliculas.stream()
                .collect(Collectors.groupingBy(Pelicula::getGenero));
        System.out.println(peliculasGenero);













    }
}