package com.accenture.photos.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="GEO")
public class Geo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lat;
    private String lng;
}
