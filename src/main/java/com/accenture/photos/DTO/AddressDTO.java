package com.accenture.photos.DTO;

import com.accenture.photos.model.Geo;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@JsonNaming( value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AddressDTO {


    private Long id;
    private String street;
    private String suite;
    private String city;
    private String zipCode;
    private GeoDto geo;
}
