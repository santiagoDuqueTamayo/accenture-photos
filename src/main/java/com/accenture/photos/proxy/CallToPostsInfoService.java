package com.accenture.photos.proxy;

import com.accenture.photos.DTO.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="posts", url = "${json-place-holder.url}")
public interface CallToPostsInfoService {

    @GetMapping(value = "/posts")
    List<PostDTO> getPosts();
}
