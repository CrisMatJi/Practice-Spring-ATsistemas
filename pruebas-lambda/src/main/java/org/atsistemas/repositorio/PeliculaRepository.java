package org.atsistemas.repositorio;
import org.atsistemas.entidades.Pelicula;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;



public class PeliculaRepository {

    private Map<Integer, Pelicula> peliculas;

    public PeliculaRepository() {
        peliculas = new HashMap<>();
        peliculas.put(siguienteIdPelicula(),
                new Pelicula(siguienteIdPelicula(), "2001", "Stanley Kubrik", "Ci-Fi", 1968));
        peliculas.put(siguienteIdPelicula(),
                new Pelicula(siguienteIdPelicula(), "Alien", "Ridley Scott", "Ci-Fi", 1979));
        peliculas.put(siguienteIdPelicula(),
                new Pelicula(siguienteIdPelicula(), "Die Hard", "John McTiernan", "Accion", 1988));
        peliculas.put(siguienteIdPelicula(),
                new Pelicula(siguienteIdPelicula(), "La máscara del Zorro", "Martin Campbell", "Accion", 1998));
        peliculas.put(siguienteIdPelicula(),
                new Pelicula(siguienteIdPelicula(), "Young Frankenstein", "Mel Brooks", "Comedia", 1974));
        peliculas.put(siguienteIdPelicula(),
                new Pelicula(siguienteIdPelicula(), "Moon", "Duncan Jones", "Ci-Fi", 2009));
        peliculas.put(siguienteIdPelicula(),
                new Pelicula(siguienteIdPelicula(), "El bueno, el feo y el malo", "Sergio Leone", "Western", 1968));
        peliculas.put(siguienteIdPelicula(),
                new Pelicula(siguienteIdPelicula(), "Interestellar", "Christopher Nolan", "Ci-Fi", 2014));
        peliculas.put(siguienteIdPelicula(),
                new Pelicula(siguienteIdPelicula(), "El tren de las 3:10", "Delmer Daves", "Western", 1957));
    }

    private Integer siguienteIdPelicula() {
        return peliculas.values().stream().max(Comparator.comparing(Pelicula::getId)).map(p -> p.getId() + 1).orElse(1);
    }

    public Collection<Pelicula> obtenerPeliculas() {
        return peliculas.values();
    }

    public Pelicula buscarPelicula(Integer id) {
        return peliculas.get(id);
    }

}