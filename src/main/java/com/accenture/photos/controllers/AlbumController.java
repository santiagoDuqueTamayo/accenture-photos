package com.accenture.photos.controllers;

import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.handlers.interfaces.AlbumHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumController {

    @Autowired
    AlbumHandler albumHandler;

    @PostMapping(value = "/albums-permissions")
    public String createAlbum(@RequestBody AlbumWithPermissionDTO albumWithPermissionDTO) {
      //TODO arreglar el mapeo de los json para que sea con nombres separados por _
       String respuesta =  albumHandler.splitDtoByEntity(albumWithPermissionDTO);
       return respuesta;
    }
}
