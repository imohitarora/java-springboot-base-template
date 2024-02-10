package com.aboutmohit.springbase.base;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO {
    @Schema(hidden = true)
    private Long id;

    @Schema(hidden = true)
    private String createdBy;

    @Schema(hidden = true)
    private LocalDateTime createdDate;

    @Schema(hidden = true)
    private String lastModifiedBy;

    @Schema(hidden = true)
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