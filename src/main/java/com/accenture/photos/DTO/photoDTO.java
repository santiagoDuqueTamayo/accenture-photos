package com.accenture.photos.DTO;

import lombok.Data;

@Data
public class photoDTO {

    private Long id;
    private Long albumId;
    private String title;
    private String url;
    private String thumbnailUrl;
}
