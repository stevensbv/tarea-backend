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

import com.beltran.dto.PersonDTO;
import com.beltran.models.Person;
import com.beltran.service.impl.PersonServiceImp;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
	
	  private final PersonServiceImp service;
	  
	  @Qualifier("defaultMapper")
	  private final ModelMapper maper;
	 
	  
	 private PersonDTO convertToDto(Person obj){
		 return maper.map(obj,PersonDTO.class);
	 }

	 private Person convertToEntity(PersonDTO obj){
		 return maper.map(obj,Person.class);
	 }

	  
	  @GetMapping
	  public ResponseEntity<List<PersonDTO>> findAll(){
		  List<PersonDTO> lista=service.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
		  return new ResponseEntity<>(lista, HttpStatus.OK);
	  }
	  
	  @GetMapping("/{id}")
	  public ResponseEntity<PersonDTO> findAllById(@PathVariable("id") Integer id){
		  PersonDTO person= convertToDto(service.findById(id));
		  return new ResponseEntity<>(person, HttpStatus.OK);
	  }
	  
	  @PostMapping
	  public ResponseEntity<Void> save(@Valid @RequestBody PersonDTO personDto){	  
		  Person obj= service.save(this.convertToEntity(personDto));	
		  URI URI= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPerson()).toUri();
		  return  ResponseEntity.created(URI).build();
	  }
	  
	 @PutMapping("/{id}")
	 public ResponseEntity<PersonDTO> update(@Valid @RequestBody PersonDTO personDto,@PathVariable("id") Integer id ){
		 personDto.setIdPerson(id);
		 Person per= service.update(this.convertToEntity(personDto), id);
		 return new ResponseEntity<>(this.convertToDto(per), HttpStatus.OK); 
		 
	 }
	  
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> delete(@PathVariable("id") Integer id ){
		 service.deleteById(id);
		 return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }

}
