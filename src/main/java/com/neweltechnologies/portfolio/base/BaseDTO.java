package com.neweltechnologies.portfolio.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO<ID extends Serializable> {
    private ID id;
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
    private boolean active;

    // Getters and setters

    public static <ID extends Serializable> BaseDTO<ID> fromEntity(BaseEntity entity) {
        BaseDTO<ID> dto = new BaseDTO<>();
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setLastModifiedBy(entity.getLastModifiedBy());
        dto.setLastModifiedDate(entity.getLastModifiedDate());
        dto.setActive(entity.isActive());
        // Map other common fields

        return dto;
    }
}