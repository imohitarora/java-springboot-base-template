package com.neweltechnologies.portfolio.users;

import com.neweltechnologies.portfolio.base.BaseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO {
    private String username;
    private String email;

    public UserDTO(User entity) {
        super(entity);
    }

    public UserDTO() {
    }
}
