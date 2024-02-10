package com.aboutmohit.springbase.users;

import com.aboutmohit.springbase.base.BaseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO {

    @Schema(description = "Username", example = "john_doe")
    private String username;

    @Schema(description = "Email", example = "john@example.com")
    private String email;

    public UserDTO(User entity) {
        super(entity);
    }

    public UserDTO() {
    }
}
