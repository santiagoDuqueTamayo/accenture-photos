package com.accenture.photos.model;

import com.accenture.photos.model.enums.TypePermission;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="PERMISSION")
public class Permission {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long albumId;
    @Enumerated(EnumType.STRING)
    private TypePermission typePermission;

}
