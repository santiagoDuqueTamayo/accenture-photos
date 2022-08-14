package com.accenture.photos.repositories;

import com.accenture.photos.DTO.AlbumDTO;
import com.accenture.photos.model.Album;
import com.accenture.photos.repositories.interfaces.AlbumRepository;
import com.accenture.photos.repositories.interfaces.ManageAlbumRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ManageAlbumRepositoryImpl  implements ManageAlbumRepository {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Album createAlbum(AlbumDTO albumDTO) {
        Album album = modelMapper.map(albumDTO, Album.class);
        Album albumToSave = albumRepository.save(album);
        return albumToSave;
    }
}
