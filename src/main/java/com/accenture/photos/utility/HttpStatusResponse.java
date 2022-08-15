package com.accenture.photos.utility;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum HttpStatusResponse {
    CREATED("Elemento creado o actualizado correctamente", HttpStatus.CREATED),
    FAIL("Fallo al crear o actualizar el elemento", HttpStatus.NOT_FOUND),
    OK ("Resultado obtenido con éxito", HttpStatus.OK);

    private String description;
    private HttpStatus httpStatus;
    HttpStatusResponse(String description, HttpStatus httpStatus) {
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
