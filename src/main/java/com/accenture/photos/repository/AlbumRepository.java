package com.accenture.photos.repository;

import com.accenture.photos.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query(value = "SELECT * FROM Permission p where p.USER_ID=:userId And p.ALBUM_ID=:albumId",
            nativeQuery = true)
    List<Album> findAlbumsAssociatedWithUser(@Param("userId") Long userId, @Param("albumId") Long albumId);
}
