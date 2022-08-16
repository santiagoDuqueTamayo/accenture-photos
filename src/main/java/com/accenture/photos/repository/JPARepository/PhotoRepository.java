package com.accenture.photos.repository.JPARepository;

import com.accenture.photos.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo , Long> {
}
