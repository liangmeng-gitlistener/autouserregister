package com.gtzz.autouserregister.dao;

import com.gtzz.autouserregister.model.User;
import com.gtzz.autouserregister.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
}
