package com.beltran.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MovieDTO {
	
	    @EqualsAndHashCode.Include
	    private Integer idMovie;
	   
	    @NotNull
	    @NotEmpty
	    @Size(min=3)
	    private String name;

	    @NotNull
	    private Integer hours;

}
