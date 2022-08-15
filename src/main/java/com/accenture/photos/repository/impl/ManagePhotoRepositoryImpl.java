package com.accenture.photos.repository.impl;

import com.accenture.photos.DTO.PhotoDTO;
import com.accenture.photos.DTO.UserDTO;
import com.accenture.photos.model.Photo;
import com.accenture.photos.model.User;
import com.accenture.photos.repository.ManagePhotoRepository;
import com.accenture.photos.repository.PhotoRepository;
import com.accenture.photos.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagePhotoRepositoryImpl implements ManagePhotoRepository {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private PhotoRepository photoRepository;



    @Override
    public void savePhotos(List<PhotoDTO> listPhotosDTOToSave) {
        List<Photo> listPhotoToSave = mapListPhotoDTOTOPhotoEntity(listPhotosDTOToSave);
        photoRepository.saveAll(listPhotoToSave);
    }


    private List<Photo> mapListPhotoDTOTOPhotoEntity(List<PhotoDTO> listPhotosDTOToSave) {
        List<Photo> listPhotoToSave = new ArrayList<>();
        listPhotosDTOToSave.forEach(photoDTO -> {
            listPhotoToSave.add(modelMapper.map(photoDTO, Photo.class));
        });
        return listPhotoToSave;
    }

}
