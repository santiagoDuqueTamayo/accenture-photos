package com.accenture.photos.DTO;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
@Builder
public class UserDTO implements Serializable {

    private Long id;
    private String name;
    private String userName;
    private String email;
    private AddressDTO address;
    private String phone;
    private String webSite;
    private CompanyDTO company;


}
