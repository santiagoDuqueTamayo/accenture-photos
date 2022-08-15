package com.accenture.photos.handler.impl;

import com.accenture.photos.DTO.UserDTO;
import com.accenture.photos.handler.UserHandler;
import com.accenture.photos.repository.ManageUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHandlerImpl implements UserHandler {

    @Autowired
    private ManageUserRepository manageUserRepository;
    @Override
    public void saveUsers(List<UserDTO> users) {
        manageUserRepository.saveUsers(users);
    }
}
