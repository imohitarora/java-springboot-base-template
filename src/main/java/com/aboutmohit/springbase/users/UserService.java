package com.aboutmohit.springbase.users;

import java.security.Principal;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aboutmohit.springbase.base.BaseRepository;
import com.aboutmohit.springbase.base.BaseService;

@Service
public class UserService extends BaseService<User, UserDTO> {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
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
        user.setEmail(dto.getEmail());
        user.setActive(dto.isActive());
        return user;
    }

    @Override
    protected void mapDtoToEntity(UserDTO dto, User entity) {
        entity.setEmail(dto.getEmail());
        entity.setActive(dto.isActive());
    }

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        userRepository.save(user);
    }
}