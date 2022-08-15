package com.accenture.photos.job;

import com.accenture.photos.DTO.AlbumDTO;
import com.accenture.photos.DTO.PhotoDTO;
import com.accenture.photos.DTO.UserDTO;
import com.accenture.photos.controller.AlbumController;
import com.accenture.photos.controller.PhotoController;
import com.accenture.photos.controller.UserController;
import com.accenture.photos.handler.AlbumHandler;
import com.accenture.photos.handler.UserHandler;
import com.accenture.photos.repository.ManagePhotoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class fetchWebServiceInformationJob {

    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;

    private final long HORA = MINUTO * 60;


    @Autowired
    private UserController userController;

    @Autowired
    private UserHandler userHandler;

    @Autowired
    private AlbumController albumController;

    @Autowired
    private AlbumHandler albumHandler;

    @Autowired
    private PhotoController photoController;

    @Autowired
    private ManagePhotoRepository  managePhotoRepository;

    @Scheduled(fixedDelay = HORA)
    public void fetchWebServiceInformation() {
        savePhotos();
        saveUsers();
        savePhotos();
    }

    private void saveAlbums() {
        List<AlbumDTO> albumsFromServices = albumController.getAlbums();
        albumHandler.saveAlbums(albumsFromServices);
    }

    private void saveUsers() {
        List<UserDTO> usersFromServices = userController.getUsers();
        userHandler.saveUsers(usersFromServices);
    }

    private void savePhotos() {
        List<PhotoDTO> photosFromServices = photoController.getPhotos();
        managePhotoRepository.savePhotos(photosFromServices);
    }
}
