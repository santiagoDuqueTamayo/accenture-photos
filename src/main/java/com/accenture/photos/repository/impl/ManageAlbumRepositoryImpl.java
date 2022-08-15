package com.accenture.photos.repository.impl;

import com.accenture.photos.DTO.AlbumDTO;
import com.accenture.photos.model.Album;
import com.accenture.photos.repository.AlbumRepository;
import com.accenture.photos.repository.ManageAlbumRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManageAlbumRepositoryImpl  implements ManageAlbumRepository {

    @Autowired
    @Lazy
    ModelMapper modelMapper;

    @Autowired
    AlbumRepository albumRepository;

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public AlbumDTO createAlbum(AlbumDTO albumDTO) {
        Album album = modelMapper.map(albumDTO, Album.class);
        //TODO probar si salta la excepción cuando venga nulo el objeto
        Album albumToSave = albumRepository.save(album);
        AlbumDTO albumToReturn = modelMapper.map(albumToSave, AlbumDTO.class);
        return albumToReturn;
    }

    @Override
    public AlbumDTO getAlbumsAccordingPermission(Long albumId) throws Exception {
        Optional<Album> albumToGet = albumRepository.findById(albumId);
        AlbumDTO albumToReturn;
        //TODO crear excepción personalizada para retornar
        if(albumToGet.isPresent()) {
            albumToReturn =  modelMapper.map(albumToGet.get(), AlbumDTO.class);
        } else {
            throw new Exception();
        }
        return albumToReturn;
    }
}
