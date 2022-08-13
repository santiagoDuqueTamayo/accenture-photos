package com.accenture.photos.proxy;

import com.accenture.photos.DTO.PhotoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="photos", url = "${json-place-holder.url}")
public interface CallToPhotsInfoService {

    @GetMapping(value = "/photos")
    List<PhotoDTO> getPhotos();
}
