package com.accenture.photos.repository.impl;

import com.accenture.photos.DTO.PhotoDTO;
import com.accenture.photos.model.Photo;
import com.accenture.photos.repository.ManagePhotoRepository;
import com.accenture.photos.repository.JPARepository.PhotoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
