package org.springframework.security.oauth.examples.sparklr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.oauth.examples.sparklr.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by zwan on 1/14/20.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
