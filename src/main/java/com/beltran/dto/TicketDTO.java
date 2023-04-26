package com.beltran.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TicketDTO {

    @EqualsAndHashCode.Include
    private Integer idTicket;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull    
    private PersonDTO person;

    @NotNull
    private double total;

    @NotNull
    @JsonManagedReference
    private List<TicketDetailDTO> details;
}
