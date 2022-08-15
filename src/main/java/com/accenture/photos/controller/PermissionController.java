package com.accenture.photos.controller;

import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.error.ApiResponse;
import com.accenture.photos.handler.PermissionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PermissionController {

    @Autowired
    PermissionHandler permissionHandler;

    @PostMapping(value = "/users-permissions")
    public ResponseEntity<ApiResponse> updateUserPermission(@RequestBody PermissionDTO permissionDTO) {
        ApiResponse responseUpdatePermission =  permissionHandler.CallRepositoryToUpdatePermission(permissionDTO);
        return  new ResponseEntity<>(responseUpdatePermission,
                responseUpdatePermission.getNotification().getHttpStatus());
    }
}
