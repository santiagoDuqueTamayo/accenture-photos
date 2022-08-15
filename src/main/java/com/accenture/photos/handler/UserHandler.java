package com.accenture.photos.handler;

import com.accenture.photos.DTO.UserDTO;

import java.util.List;

public interface UserHandler {
    void saveUsers(List<UserDTO> users);
}
