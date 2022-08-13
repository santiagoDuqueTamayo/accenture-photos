package com.accenture.photos.proxy;

import com.accenture.photos.DTO.AlbumDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="albums", url = "${json-place-holder.url}")
public interface CallToAlbumsInfoService {

    @GetMapping(value = "/albums")
    List<AlbumDTO> getAlbums();
}
