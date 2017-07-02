package com.michal.repository;

import com.michal.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mike on 2017-07-01.
 */
public interface AddressRepo extends JpaRepository<Address,Long> {
}
