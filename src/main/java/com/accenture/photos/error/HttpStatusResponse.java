package com.accenture.photos.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
public enum HttpStatusResponse {
    CREATED("Elemento creado o actualizado correctamente", HttpStatus.CREATED),
    FAIL("Fallo al crear o actualizar el elemento", HttpStatus.NOT_FOUND);

    private String description;
    private HttpStatus httpStatus;
    HttpStatusResponse(String description, HttpStatus httpStatus) {
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
