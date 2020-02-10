package com.gtzz.autouserregister.dao;

import com.gtzz.autouserregister.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
