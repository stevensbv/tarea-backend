package com.beltran.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TicketDetailDTO {
	
	    @EqualsAndHashCode.Include
	    private Integer idTicketDetail;
	    

	    @JsonBackReference
	    private TicketDTO ticket;
	    
	    @NotNull
	    private MovieDTO movie;
	    
	    @NotNull
	    private Integer quantity;


}
