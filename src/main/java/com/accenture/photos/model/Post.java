package com.accenture.photos.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="POSTS")
public class Post {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String title;

}
