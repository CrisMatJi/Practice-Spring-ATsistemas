package com.atsistemas.formacion.base.spring.examplewebapp.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.atsistemas.formacion.base.spring.examplewebapp.model.Pelicula;
import com.atsistemas.formacion.base.spring.examplewebapp.service.PeliculasService;

@Service
public class PeliculasServiceImpl implements PeliculasService {

	private Map<Integer, Pelicula> peliculas;

	public PeliculasServiceImpl() {
		peliculas = new HashMap<>();
		peliculas.put(siguienteIdPelicula(),
				new Pelicula(siguienteIdPelicula(), "2001", "Stanley Kubrik", "Ci-Fi", "1968"));
		peliculas.put(siguienteIdPelicula(),
				new Pelicula(siguienteIdPelicula(), "Alien", "Ridley Scott", "Ci-Fi", "1979"));
		peliculas.put(siguienteIdPelicula(),
				new Pelicula(siguienteIdPelicula(), "Die Hard", "John McTiernan", "Accion", "1988"));
		peliculas.put(siguienteIdPelicula(),
				new Pelicula(siguienteIdPelicula(), "Young Frankenstein", "Mel Brooks", "Comedia", "1974"));
		peliculas.put(siguienteIdPelicula(),
				new Pelicula(siguienteIdPelicula(), "Moon", "Duncan Jones", "Ci-Fi", "2009"));
		peliculas.put(siguienteIdPelicula(),
				new Pelicula(siguienteIdPelicula(), "El bueno, el feo y el malo", "Sergio Leone", "Western", "1968"));
	}

	@Override
	public void guardarPelicula(Pelicula pelicula) {
		if (pelicula.getId() == null) {
			Integer siguienteIdPelicula = siguienteIdPelicula();
			pelicula.setId(siguienteIdPelicula);
			peliculas.put(siguienteIdPelicula, pelicula);
		} else {
			Pelicula peliculaAlmacenada = peliculas.get(pelicula.getId());
			peliculaAlmacenada.setTitulo(pelicula.getTitulo());
			peliculaAlmacenada.setDirector(pelicula.getDirector());
			peliculaAlmacenada.setGenero(pelicula.getGenero());
			peliculaAlmacenada.setFechaEstreno(pelicula.getFechaEstreno());
		}
	}

	@Override
	public List<Pelicula> listarPeliculas() {
		return new ArrayList<>(peliculas.values());
	}

	@Override
	public Pelicula buscarPelicula(Integer id) {
		return peliculas.get(id);
	}

	private Integer siguienteIdPelicula() {
		return peliculas.values().stream().max(Comparator.comparing(Pelicula::getId)).map(p-> p.getId() + 1).orElse(1);
	}

	@Override
	public void eliminarPelicula(Integer idPelicula) {
		peliculas.remove(idPelicula);
	}

}
