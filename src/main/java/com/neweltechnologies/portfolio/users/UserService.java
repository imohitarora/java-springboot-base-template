package com.neweltechnologies.portfolio.users;

import org.springframework.stereotype.Service;

import com.neweltechnologies.portfolio.base.BaseRepository;
import com.neweltechnologies.portfolio.base.BaseService;

@Service
public class UserService extends BaseService<User, UserDTO> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected BaseRepository<User> getRepository() {
        return userRepository;
    }

    @Override
    protected UserDTO mapToDTO(User entity) {
        UserDTO dto = new UserDTO(entity);
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    @Override
    protected User mapToEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setActive(dto.isActive());
        return user;
    }

    @Override
    protected void mapDtoToEntity(UserDTO dto, User entity) {
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getEmail());
        entity.setActive(dto.isActive());
    }
}