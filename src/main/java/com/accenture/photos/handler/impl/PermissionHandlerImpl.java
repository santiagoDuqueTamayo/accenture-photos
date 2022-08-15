package com.accenture.photos.handler.impl;

import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.utility.ApiResponse;
import com.accenture.photos.utility.HttpStatusResponse;
import com.accenture.photos.utility.Notification;
import com.accenture.photos.handler.PermissionHandler;
import com.accenture.photos.repository.ManagePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionHandlerImpl implements PermissionHandler {

    @Autowired
    private ManagePermissionRepository managePermissionRepository;

    @Override
    public ApiResponse CallRepositoryToUpdatePermission(PermissionDTO permissionDTO) {
        Boolean isUpdatePermission = managePermissionRepository.updateUserPermission(permissionDTO);
        return createResponse(isUpdatePermission);
    }

    @Override
    public ApiResponse CallRepositoryToGetUsersByTpe(PermissionDTO permissionDTO) {
        //TODO controlar la respuesta negativa
        List<PermissionDTO> listToReturn = managePermissionRepository.
                getUserByTypePermission(permissionDTO);
        return createResponseUsersByType(listToReturn);
    }

    private ApiResponse createResponseUsersByType(List<PermissionDTO> listPermissionDTO) {
        Notification notification = buildNotification(HttpStatusResponse.OK);
        ApiResponse apiResponse = ApiResponse.builder().
                response(listPermissionDTO).
                notification(notification).
                build();
        return apiResponse;
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
