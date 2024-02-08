package com.neweltechnologies.portfolio.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neweltechnologies.portfolio.base.BaseService;
import com.neweltechnologies.portfolio.config.audit.AuditTrail;
import com.neweltechnologies.portfolio.userprofile.UserProfile;
import com.neweltechnologies.portfolio.userprofile.UserProfileDTO;

@Service
public class UserService extends BaseService<Long, User, UserDTO> {

    @Autowired
    private UserRepository userRepository;

    @AuditTrail(entityName = "User", action = "CREATE")
    public User createUser(User user) {
        UserProfile profile = user.getProfile();
        if (profile != null) {
            profile.setUser(user);
        }
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    @Override
    protected User mapToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setProfile(new UserProfile(dto.getProfile().getId(), dto.getProfile().getFirstName(),
                dto.getProfile().getLastName(), user));
        return user;
    }

    @Override
    protected UserDTO mapToDTO(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setProfile(UserProfileDTO.Mapper.toDTO(entity.getProfile()));
        return dto;
    }

}
