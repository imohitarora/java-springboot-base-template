package com.neweltechnologies.portfolio.base;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO {
    private Long id;
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
    private boolean active;

    // Getters and setters

    public BaseDTO() {
    }

    public BaseDTO(BaseEntity entity) {
        this.id = entity.getId();
        this.createdBy = entity.getCreatedBy();
        this.createdDate = entity.getCreatedDate();
        this.lastModifiedBy = entity.getLastModifiedBy();
        this.lastModifiedDate = entity.getLastModifiedDate();
        this.active = entity.isActive();
    }
}