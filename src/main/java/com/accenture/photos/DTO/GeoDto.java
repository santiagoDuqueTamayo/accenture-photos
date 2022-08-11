package com.accenture.photos.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming( value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GeoDto {
    private Long id;
    private String lat;
    private String lng;
}
