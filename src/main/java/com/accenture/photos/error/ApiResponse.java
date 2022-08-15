package com.accenture.photos.error;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ApiResponse<T> {

    private  T response;
    private Notification notification;

    public ApiResponse(Notification notification) {
        this.notification = notification;
    }

}
