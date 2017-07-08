package com.michal.repository;

import com.michal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mike on 2017-07-01.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
