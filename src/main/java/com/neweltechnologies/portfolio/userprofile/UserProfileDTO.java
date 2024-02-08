package com.neweltechnologies.portfolio.userprofile;

import com.neweltechnologies.portfolio.base.BaseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileDTO extends BaseDTO<Long> {

    private String firstName;
    private String lastName;

    // Getters and setters

    public static UserProfileDTO fromEntity(UserProfile profile) {
        UserProfileDTO dto = new UserProfileDTO();
        dto.setFirstName(profile.getFirstName());
        dto.setLastName(profile.getLastName());
        return dto;
    }

    // Mapper class for UserProfileDTO
    public static class Mapper {
        public static UserProfileDTO toDTO(UserProfile profile) {
            UserProfileDTO dto = new UserProfileDTO();
            dto.setId(profile.getId());
            dto.setFirstName(profile.getFirstName());
            dto.setLastName(profile.getLastName());
            return dto;
        }
    }
}
