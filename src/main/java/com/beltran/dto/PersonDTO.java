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
public class PersonDTO {
	

    @EqualsAndHashCode.Include
    private Integer idPerson;

    @NotNull
    @NotEmpty
    @Size(min=3)
    private String firstname;

    @NotNull
    @NotEmpty
    @Size(min=3)
    private String lastname;

}
