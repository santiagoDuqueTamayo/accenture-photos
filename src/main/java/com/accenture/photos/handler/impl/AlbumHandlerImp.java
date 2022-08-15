package com.accenture.photos.handler.impl;

import com.accenture.photos.DTO.AlbumDTO;
import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.utility.ApiResponse;
import com.accenture.photos.utility.HttpStatusResponse;
import com.accenture.photos.utility.Notification;
import com.accenture.photos.handler.AlbumHandler;
import com.accenture.photos.model.Permission;
import com.accenture.photos.repository.ManageAlbumRepository;
import com.accenture.photos.repository.ManagePermissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumHandlerImp implements AlbumHandler {

    @Autowired
    ManageAlbumRepository manageAlbumRepository;

    @Autowired
    ManagePermissionRepository managePermissionRepository;

    @Override
    public ApiResponse splitDtoByEntity(AlbumWithPermissionDTO albumWithPermissionDTO) {
        AlbumDTO albumDTO = createAlbumDTO(albumWithPermissionDTO);
        List<com.accenture.photos.DTO.PermissionDTO> permissions = createPermissions(albumWithPermissionDTO);
        AlbumDTO albumWasSaved =  manageAlbumRepository.createAlbum(albumDTO);
        List<Permission> permissionsWereSaved = managePermissionRepository.savePermissions(permissions);
        return buildResponseSuccessful(albumWasSaved, HttpStatusResponse.CREATED);
    }

    @Override
    public ApiResponse getAlbumsAccordingPermissions(Long userId, Long albumId) {

        Boolean userHasPermission = managePermissionRepository.verifyPermissionUser(userId, albumId);
        return userHasPermission ? managePermissionSuccessfulResponse(albumId) :
                new ApiResponse(buildNotificationResponse(HttpStatusResponse.UNAUTHORIZED));

    }

    private ApiResponse managePermissionSuccessfulResponse(Long albumId) {
        ApiResponse albumsResponse;
        //TODO dejar esto sin  try catch, contemplar implementar vvar
        try {
           AlbumDTO albumDTO = manageAlbumRepository.getAlbumsAccordingPermission(albumId);
           albumsResponse = buildResponseSuccessful(albumDTO, HttpStatusResponse.OK);
        } catch (Exception e){
            albumsResponse = new ApiResponse(buildNotificationResponse(HttpStatusResponse.FAIL));
        }
        return albumsResponse;
    }


    private ApiResponse buildResponseSuccessful(AlbumDTO albumWasSaved, HttpStatusResponse statusResponse) {
        Notification notification = buildNotificationResponse(statusResponse);
        ApiResponse apiToReturn = ApiResponse.builder().
                response(albumWasSaved).
                notification(notification).
                build();
        return apiToReturn;
    }

    private static Notification buildNotificationResponse(HttpStatusResponse statusResponse) {
        Notification notification = Notification.builder().description(
                statusResponse.getDescription()).
                httpStatus(statusResponse.getHttpStatus()).
                build();
        return notification;
    }

    private List<com.accenture.photos.DTO.PermissionDTO> createPermissions(AlbumWithPermissionDTO albumWithPermissionDTO) {
       List<com.accenture.photos.DTO.PermissionDTO> permissionDTOS = albumWithPermissionDTO.getPermissions();
       return permissionDTOS;
    }

    private AlbumDTO createAlbumDTO(AlbumWithPermissionDTO albumWithPermissionDTO) {
        AlbumDTO albumToSend = AlbumDTO.builder().
                id(albumWithPermissionDTO.getId()).
                userId(albumWithPermissionDTO.getUserId()).
                title(albumWithPermissionDTO.getTitle()).
                build();
        return albumToSend;
    }
}
