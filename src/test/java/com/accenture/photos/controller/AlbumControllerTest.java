package com.accenture.photos.controller;

import com.accenture.photos.DTO.AlbumDTO;
import com.accenture.photos.handler.AlbumHandler;
import com.accenture.photos.utility.ApiResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AlbumController.class)
class AlbumControllerTest {

    @MockBean
    AlbumHandler albumHandler;

    @Autowired
    MockMvc mockMvc;
    
    @BeforeEach
    void setUp() {
    }

    @Test
    void given_albumAnPermission_when_createAlbum_then_returnAlbumCreated() throws Exception {
        when(albumHandler.splitDtoByEntity(any())).thenReturn(buildAlbumToReturn());

        mockMvc.perform(get("/albums-permissions"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].user_id", Matchers.is("5002")));
    }

    private ApiResponse buildAlbumToReturn() {
        AlbumDTO albumDTO = AlbumDTO.builder().
                id(5127l).
                userId(5002l).
                title("prueba").
                build();
        ApiResponse apiResponse = ApiResponse.builder().
                response(albumDTO).
                build();
        return apiResponse;
    }
}