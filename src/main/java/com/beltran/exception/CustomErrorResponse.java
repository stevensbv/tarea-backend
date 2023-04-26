package com.beltran.exception;

//fORMA CLASICA DESDE SPRING 1 -3
//Detalle del error, personalizar

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse {

    private LocalDateTime dateTime;
    private String mensaje;
    private String details;
}
