package com.neweltechnologies.portfolio.users;

import org.springframework.stereotype.Repository;

import com.neweltechnologies.portfolio.base.BaseRepository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
}
