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
@Table(name="USER_P")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String name;
    private String userName;
    private String email;
    @ManyToOne (cascade=CascadeType.ALL)
    private Address adress;
    private String phone;
    private String webSite;
    @ManyToOne (cascade=CascadeType.ALL)
    private Company company;
    @ManyToMany
    private List<Album> albums;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<Post> posts;

}
