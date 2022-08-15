package com.accenture.photos.handler.impl;

import com.accenture.photos.DTO.PermissionDTO;
import com.accenture.photos.handler.PermissionHandler;
import com.accenture.photos.repository.ManagePermissionRepository;
import com.accenture.photos.utility.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PermissionHandlerImplTest {

    @InjectMocks
    private PermissionHandlerImpl permissionHandler;

    @Mock
    private ManagePermissionRepository managePermissionRepository;


    @BeforeEach
    void setUp() {
    }

    @Test
    void given_userAndNewPermission_when_userUpdateTypePermission_then_descriptionIsSuccessful() {
        Boolean isPermissionUpdate = Boolean.TRUE;
        String messageDescriptionWhenUserIsUpdate = "Elemento creado o actualizado correctamente";
        when(managePermissionRepository.updateUserPermission(any())).thenReturn(isPermissionUpdate);
        ApiResponse responsewhenUserWasUpdate = permissionHandler.
                CallRepositoryToUpdatePermission(createPermissionDTO());
        String MessageGotToUpdate = responsewhenUserWasUpdate.getNotification().getDescription();
        assertEquals(messageDescriptionWhenUserIsUpdate, MessageGotToUpdate);
    }

    @Test
    void given_userAndAlbumCombinatedDoesNotExist_when_userUpdateTypePermission_then_descriptionIsFail() {
        Boolean isNotPermissionUpdate = Boolean.FALSE;
        String messageDescriptionWhenUserIsNotUpdate = "Fallo al crear o actualizar el elemento";
        when(managePermissionRepository.updateUserPermission(any())).thenReturn(isNotPermissionUpdate);
        ApiResponse responsewhenUserWasUpdate = permissionHandler.
                CallRepositoryToUpdatePermission(createPermissionDTO());
        String MessageGotToNotUpdate = responsewhenUserWasUpdate.getNotification().getDescription();
        assertEquals(messageDescriptionWhenUserIsNotUpdate, MessageGotToNotUpdate);
    }

    @Test
    void give_albumAndTyperPermission_when_findUsersByType_then_listUsersByType() {
        Integer amountUsersToReturn = 2;
        when(managePermissionRepository.getUserByTypePermission(any())).thenReturn(buildListToResponse());
        ApiResponse listresponse = permissionHandler.
                CallRepositoryToGetUsersByTpe(buildPermission(1l, 1l, "WRITE"));
        List<PermissionDTO> listPermissionsWasReturned = (List<PermissionDTO>) listresponse.getResponse();
        assertEquals(amountUsersToReturn, listPermissionsWasReturned.size());

    }

    private List<PermissionDTO> buildListToResponse() {
        List<PermissionDTO> listToReturn = new ArrayList<>();
        PermissionDTO permissionDTOToUser1 = buildPermission(1l, 1l, "WRITE");
        PermissionDTO permissionDTOToUser2 = buildPermission(2l, 1l, "WRITE");
        listToReturn.add(permissionDTOToUser1);
        listToReturn.add(permissionDTOToUser2);
        return listToReturn;
    }

    private static PermissionDTO buildPermission(long userId, long albumId, String WRITE) {
        PermissionDTO permissionDTOToUser1 = PermissionDTO.builder().
                userId(userId).
                albumId(albumId).
                typePermission(WRITE).
                build();
        return permissionDTOToUser1;
    }

    private PermissionDTO createPermissionDTO() {
        PermissionDTO permissionToUpdateDTO = PermissionDTO.builder().
                userId(7l).
                albumId(8l).
                typePermission("READ").
                build();
        return permissionToUpdateDTO;
    }


}