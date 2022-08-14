package com.accenture.photos.repository.interfaces;

import com.accenture.photos.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
