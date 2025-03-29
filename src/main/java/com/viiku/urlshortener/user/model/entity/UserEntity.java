package com.viiku.urlshortener.user.model.entity;

import com.viiku.urlshortener.common.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

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

    /**
     * This is Database primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false)
    private String id;

    /**
     * This is a Business key
     */
    @NaturalId(mutable = false)
    @Column(name = "userid", nullable = false, unique = true, length = 50)
    private String userId;

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;

    @Column(nullable = false)
    private String password;
}
