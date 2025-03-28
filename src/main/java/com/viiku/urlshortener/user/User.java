package com.viiku.urlshortener.user;

import com.viiku.urlshortener.common.model.BaseDomainModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseDomainModel {

    private String id;
    private String name;
    private String email;
}
