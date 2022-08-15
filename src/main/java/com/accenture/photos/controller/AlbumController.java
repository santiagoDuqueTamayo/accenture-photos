package com.accenture.photos.controller;

import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.utility.ApiResponse;
import com.accenture.photos.handler.AlbumHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlbumController {

    @Autowired
    AlbumHandler albumHandler;

    @PostMapping(value = "/albums-permissions")
    public ResponseEntity<ApiResponse> createAlbum(@RequestBody AlbumWithPermissionDTO albumWithPermissionDTO) {
      //TODO arreglar el mapeo de los json para que sea con nombres separados por _
       ApiResponse responseAlbum =  albumHandler.splitDtoByEntity(albumWithPermissionDTO);
       return new ResponseEntity<>(responseAlbum,
               responseAlbum.getNotification().getHttpStatus());
    }

    @GetMapping(value = "/albums-according-permissions")
    public ResponseEntity<ApiResponse> getAlbumsAccordingPermissions(@RequestParam Long userId,
                                                      @RequestParam Long albumId) {
        ApiResponse albumResponse =  albumHandler.getAlbumsAccordingPermissions(userId, albumId);
        return  new ResponseEntity<>(albumResponse,
                albumResponse.getNotification().getHttpStatus());
    }
}
