package com.beltran.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	
	  @Bean("defaultMapper")
	  ModelMapper modelMapper(){
	     return new ModelMapper();
	  }

}
