package com.beltran.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.beltran.dto.MovieDTO;
import com.beltran.models.Movie;
import com.beltran.service.impl.MovieServiceImp;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

	private final MovieServiceImp service;

	@Qualifier("defaultMapper")
	private final ModelMapper maper;

	private MovieDTO convertToDto(Movie obj) {
		return maper.map(obj, MovieDTO.class);
	}

	private Movie convertToEntity(MovieDTO obj) {
		return maper.map(obj, Movie.class);
	}

	@GetMapping
	public ResponseEntity<List<MovieDTO>> findAll() {
		List<MovieDTO> lista = service.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> findAllById(@PathVariable("id") Integer id) {
		MovieDTO Movie = convertToDto(service.findById(id));
		return new ResponseEntity<>(Movie, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody MovieDTO movieDto) {
		Movie obj = service.save(this.convertToEntity(movieDto));
		URI URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMovie())
				.toUri();
		return ResponseEntity.created(URI).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<MovieDTO> update(@Valid @RequestBody MovieDTO movieDto, @PathVariable("id") Integer id) {
		movieDto.setIdMovie(id);
		Movie per = service.update(this.convertToEntity(movieDto), id);
		return new ResponseEntity<>(this.convertToDto(per), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
