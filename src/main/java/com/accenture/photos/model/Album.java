package com.accenture.photos.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name="ALBUM")
public class Album {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String title;
    @OneToMany
    @JoinColumn(name = "albumId")
    private List<Photo> albums;

}
