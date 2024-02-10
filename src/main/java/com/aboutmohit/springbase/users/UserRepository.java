package com.aboutmohit.springbase.users;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.aboutmohit.springbase.base.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByEmail(String email);
}
