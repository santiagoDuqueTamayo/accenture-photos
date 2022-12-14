package com.accenture.photos.repository.JPARepository;

import com.accenture.photos.model.Permission;
import com.accenture.photos.model.enums.TypePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PermissionReposiory extends JpaRepository<Permission, Long> {

    @Query(value = "SELECT * FROM Permission p where p.USER_ID=:userId And p.ALBUM_ID=:albumId",
            nativeQuery = true)
    Permission findPermissionByAlbumIdAndUserId(@Param("userId") Long userId, @Param("albumId") Long albumId);

    @Query(value = "SELECT * FROM Permission p where p.TYPE_PERMISSION=:typePermission And p.ALBUM_ID=:albumId",
            nativeQuery = true)
    List<Permission> getUsersByTypePermission(@Param("typePermission") TypePermission typePermission, @Param("albumId") Long albumId);

    @Query(value = "SELECT * FROM Permission p where p.USER_ID=:userId And p.ALBUM_ID=:albumId",
            nativeQuery = true)
    Permission verifyPermissionUser(@Param("userId") Long userId, @Param("albumId") Long albumId);
}
