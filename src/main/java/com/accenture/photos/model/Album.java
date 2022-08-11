package com.accenture.photos.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String title;
    @OneToMany
    private List<Photo> albums;

}
