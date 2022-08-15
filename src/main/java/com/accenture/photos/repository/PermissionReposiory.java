package com.accenture.photos.repository;

import com.accenture.photos.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PermissionReposiory extends JpaRepository<Permission, Long> {

    @Query(value = "SELECT * FROM Permission p where p.USER_ID=:userId And p.ALBUM_ID=:albumId",
            nativeQuery = true)
    Permission findPermissionByAlbumIdAndUserId(@Param("userId") Long userId, @Param("albumId") Long albumId);
}
