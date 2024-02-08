package com.neweltechnologies.portfolio.users;

import com.neweltechnologies.portfolio.base.BaseDTO;
import com.neweltechnologies.portfolio.userprofile.UserProfileDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO<Long> {
    private String username;
    private String email;
    private UserProfileDTO profile;

    // Getters and setters

    public static UserDTO fromEntity(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setProfile(UserProfileDTO.Mapper.toDTO(user.getProfile()));
        return dto;
    }
}
