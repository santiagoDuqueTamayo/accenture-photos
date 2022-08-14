package com.accenture.photos.error;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ApiResponse<T> {

    private  T response;
    private HttpStatusResponse httpStatusResponse;

}
