package com.accenture.photos.proxy;

import com.accenture.photos.DTO.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="users", url = "${json-place-holder.url}")
public interface CallToUsersInfoService {

    @GetMapping(value = "/users")
    List<UserDTO> getUsers();
}
