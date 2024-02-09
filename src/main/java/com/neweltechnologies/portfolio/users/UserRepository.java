package com.neweltechnologies.portfolio.users;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.neweltechnologies.portfolio.base.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByEmail(String email);
}
