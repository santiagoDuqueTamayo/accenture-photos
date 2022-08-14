package com.accenture.photos.controller;

import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.error.ApiResponse;
import com.accenture.photos.handler.interfaces.AlbumHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumController {

    @Autowired
    AlbumHandler albumHandler;

    @PostMapping(value = "/albums-permissions")
    public ResponseEntity<ApiResponse> createAlbum(@RequestBody AlbumWithPermissionDTO albumWithPermissionDTO) {
      //TODO arreglar el mapeo de los json para que sea con nombres separados por _
       ApiResponse responseAlbum =  albumHandler.splitDtoByEntity(albumWithPermissionDTO);
       return new ResponseEntity<>(responseAlbum,
               responseAlbum.getHttpStatusResponse().getHttpStatus());
    }
}
