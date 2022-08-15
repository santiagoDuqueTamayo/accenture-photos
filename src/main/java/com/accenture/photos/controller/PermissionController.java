package com.accenture.photos.controller;

import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.utility.ApiResponse;
import com.accenture.photos.handler.PermissionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/users-permissions-types")
    public ResponseEntity<ApiResponse> getUsersByType(@RequestParam Long userId,
                                                      @RequestParam Long albumId,
                                                      @RequestParam String typePermission) {
        PermissionDTO permissionDTO = buildPermission(userId, albumId, typePermission);
        ApiResponse responseUpdatePermission =  permissionHandler.CallRepositoryToGetUsersByTpe(permissionDTO);
        return  new ResponseEntity<>(responseUpdatePermission,
                responseUpdatePermission.getNotification().getHttpStatus());
    }

    //TODO buscar la manera de no dejar este método en el controlador
    private  PermissionDTO buildPermission(Long userId, Long albumId, String typePermission) {
        return PermissionDTO.builder().
                userId(userId).
                albumId(albumId).
                typePermission(typePermission).
                build();
    }
}
