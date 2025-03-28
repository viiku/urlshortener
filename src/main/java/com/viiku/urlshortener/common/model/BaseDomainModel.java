package com.viiku.urlshortener.common.model;

import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseDomainModel {

    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
}
