package com.neweltechnologies.portfolio.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neweltechnologies.portfolio.base.BaseService;
import com.neweltechnologies.portfolio.config.audit.AuditTrail;

@Service
public class UserService extends BaseService<User, Long> {

    @Autowired
    private UserRepository userRepository;

    @AuditTrail(entityName = "User", action = "CREATE")
    public User createUser(User user) {
        User createdUser = userRepository.save(user);
        return createdUser;
    }

}
