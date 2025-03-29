package com.viiku.urlshortener.user.model;

import com.viiku.urlshortener.common.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * Entity class named {@link UserEntity}, extends BaseEntity class
 * Have User related fields like id, firstName, lastName, email, password etc..
 */

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
}
