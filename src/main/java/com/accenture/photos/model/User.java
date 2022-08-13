package com.accenture.photos.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String name;
    private String userName;
    private String email;
    @ManyToOne
    private Address adress;
    private String phone;
    private String webSite;
    @ManyToOne
    private Company company;
    @OneToMany
    private List<Album> albums;
    @OneToMany
    private List<Post> posts;

}
