package com.accenture.photos.repository.impl;

import com.accenture.photos.DTO.UserDTO;
import com.accenture.photos.model.User;
import com.accenture.photos.repository.ManageUserRepository;
import com.accenture.photos.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManageUserRepositoryImpl implements ManageUserRepository {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    UserRepository userRepository;



    @Override
    public void saveUsers(List<UserDTO> listUsersDTOToSave) {
        List<User> listUserToSave = mapListUserDTOTOUserEntity(listUsersDTOToSave);
        userRepository.saveAll(listUserToSave);
    }


    private List<User> mapListUserDTOTOUserEntity(List<UserDTO> listUsersDTOToSave) {
        List<User> listUserToSave = new ArrayList<>();
        listUsersDTOToSave.forEach(userDTO -> {
                listUserToSave.add(modelMapper.map(userDTO, User.class));
        });
        return listUserToSave;
    }
}
