package com.accenture.photos.DTO;

import com.accenture.photos.model.Address;
import com.accenture.photos.model.Company;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming ( value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDTO {

    private Long id;
    private String name;
    private String userName;
    private String email;
    private AddressDTO adress;
    private String phone;
    private String webSite;
    private CompanyDTO company;


}
