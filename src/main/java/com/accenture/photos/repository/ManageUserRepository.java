package com.accenture.photos.repository;

import com.accenture.photos.DTO.UserDTO;

import java.util.List;

public interface ManageUserRepository {

    void saveUsers (List<UserDTO> listUsersToSave);
}
