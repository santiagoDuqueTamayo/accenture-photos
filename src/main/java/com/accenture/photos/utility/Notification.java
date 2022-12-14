package com.accenture.photos.utility;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {

    private String description;
    private HttpStatus httpStatus;
}
