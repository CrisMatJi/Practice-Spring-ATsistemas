package com.atsistemas.formacion.base.spring.examplewebapp.controller;



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
	@GetMapping(value = "/peliculas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pelicula findOneById(@PathVariable Integer id) {
		Pelicula pelicula = peliculasService.buscarPelicula(id);
		return pelicula;
	}

	//Guardar una pelicula
	@PostMapping(value = "/peliculas", consumes = MediaType.APPLICATION_JSON_VALUE)
	void createPelicula(@RequestBody Pelicula pelicula) {
		peliculasService.guardarPelicula(pelicula);

	}
	//Actualiza una pelicula por ID
	@PutMapping(value = "/peliculas/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	void updatePelicula(@RequestBody Pelicula pelicula){
		peliculasService.guardarPelicula(pelicula);
	}
	//Delete una pelicula por ID
	@DeleteMapping(value = "/peliculas/{id}")
	void deletePelicula(@PathVariable Integer id){
		peliculasService.eliminarPelicula(id);
	}

}

