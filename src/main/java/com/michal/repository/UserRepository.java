package com.michal.repository;

import com.michal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mike on 2017-07-01.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
