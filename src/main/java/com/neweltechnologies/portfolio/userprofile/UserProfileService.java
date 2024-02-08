package com.neweltechnologies.portfolio.userprofile;

import org.springframework.stereotype.Service;

import com.neweltechnologies.portfolio.base.BaseService;

@Service
public class UserProfileService extends BaseService<Long, UserProfile, UserProfileDTO> {

    @Override
    protected UserProfileDTO mapToDTO(UserProfile entity) {
        UserProfileDTO dto = new UserProfileDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    @Override
    protected UserProfile mapToEntity(UserProfileDTO dto) {
        UserProfile entity = new UserProfile();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        return entity;
    }

}
