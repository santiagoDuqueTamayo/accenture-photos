package com.accenture.photos.repository.interfaces;

import com.accenture.photos.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionReposiory extends JpaRepository<Permission, Long> {
}
