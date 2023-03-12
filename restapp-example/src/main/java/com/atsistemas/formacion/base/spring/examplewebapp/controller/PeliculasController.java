package com.atsistemas.formacion.base.spring.examplewebapp.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atsistemas.formacion.base.spring.examplewebapp.model.Pelicula;
import com.atsistemas.formacion.base.spring.examplewebapp.service.PeliculasService;

import java.util.List;
import java.util.Optional;

@RestController
public class PeliculasController {

	private PeliculasService peliculasService;

	public PeliculasController(PeliculasService peliculasService) {
		this.peliculasService = peliculasService;
	}


	//Obtener listado completo de peliculas
	@GetMapping(value = "/peliculas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pelicula> findAll() {
		return peliculasService.listarPeliculas();
	}

	//Obtener una pelicula por id
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@GetMapping(value = "/peliculas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pelicula findOneById(@PathVariable Integer id) {
		Pelicula pelicula = peliculasService.buscarPelicula(id);
		return pelicula;
	}

	//Guardar una pelicula
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(value = "/peliculas", consumes = MediaType.APPLICATION_JSON_VALUE)
	Pelicula create(@RequestBody Pelicula pelicula) {
		peliculasService.guardarPelicula(pelicula);
		return pelicula;
	}
	//Actualiza una pelicula por ID

	@PutMapping(value = "/peliculas/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	Pelicula update(@RequestBody Pelicula pelicula){
		peliculasService.guardarPelicula(pelicula);
		return pelicula;
	}
	//Delete una pelicula por ID
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping(value = "/peliculas/{id}")
	void delete(@PathVariable Integer id){
		peliculasService.eliminarPelicula(id);
	}

}

