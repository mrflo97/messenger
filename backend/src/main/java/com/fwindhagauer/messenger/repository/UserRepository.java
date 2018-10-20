package com.fwindhagauer.messenger.repository;

import com.fwindhagauer.messenger.entitiy.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {

	User findUserByName(String name);
}
