package com.accenture.photos.handler.impl;

import com.accenture.photos.DTO.AlbumWithPermissionDTO;
import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.error.ApiResponse;
import com.accenture.photos.error.HttpStatusResponse;
import com.accenture.photos.error.Notification;
import com.accenture.photos.handler.PermissionHandler;
import com.accenture.photos.repository.ManagePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionHandlerImpl implements PermissionHandler {

    @Autowired
    private ManagePermissionRepository managePermissionRepository;

    @Override
    public ApiResponse CallRepositoryToUpdatePermission(PermissionDTO permissionDTO) {
        Boolean isUpdatePermission = managePermissionRepository.updateUserPermission(permissionDTO);
        return createResponse(isUpdatePermission);
    }

    private ApiResponse createResponse(Boolean isUpdatePermission) {
        Notification notificationToReturn =  isUpdatePermission ?
                buildNotification(HttpStatusResponse.CREATED) :
                buildNotification(HttpStatusResponse.FAIL);;
        ApiResponse apiResponseToReturn = new ApiResponse(notificationToReturn);
        return apiResponseToReturn;
    }

    private Notification buildNotification(HttpStatusResponse notificationStatus) {
      return  Notification.builder().
                description(notificationStatus.getDescription()).
                httpStatus(notificationStatus.getHttpStatus()).
                build();
    }
}
