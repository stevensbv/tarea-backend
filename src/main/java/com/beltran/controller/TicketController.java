package com.beltran.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.beltran.dto.TicketDTO;
import com.beltran.models.Ticket;
import com.beltran.service.impl.TicketServiceImp;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
	
	  private final TicketServiceImp service;
	  
	  @Qualifier("defaultMapper")
	  private final ModelMapper maper;
	 
	  
	 private TicketDTO convertToDto(Ticket obj){
		 return maper.map(obj,TicketDTO.class);
	 }

	 private Ticket convertToEntity(TicketDTO obj){
		 return maper.map(obj,Ticket.class);
	 }

	  
	  @GetMapping
	  public ResponseEntity<List<TicketDTO>> findAll(){
		
		  List<TicketDTO> lista=service.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
		  return new ResponseEntity<>(lista, HttpStatus.OK);
	  }
	  
	  @GetMapping("/{id}")
	  public ResponseEntity<TicketDTO> findAllById(@PathVariable("id") Integer id){
		  TicketDTO ticket= convertToDto(service.findById(id));
		  return new ResponseEntity<>(ticket, HttpStatus.OK);
	  }
	  
	  @PostMapping
	  public ResponseEntity<Void> save(@Valid @RequestBody TicketDTO ticketDto){	
		  Ticket obj= this.convertToEntity(ticketDto);
		  obj= service.save(obj);	
		  URI URI= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTicket()).toUri();
		  return  ResponseEntity.created(URI).build();
	  }

}
