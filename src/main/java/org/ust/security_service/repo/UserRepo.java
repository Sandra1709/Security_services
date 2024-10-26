package org.ust.security_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.ust.security_service.model.User_access;


@Repository
public interface UserRepo extends JpaRepository<User_access, Long> {
    User_access findByUsername(String username);
}
