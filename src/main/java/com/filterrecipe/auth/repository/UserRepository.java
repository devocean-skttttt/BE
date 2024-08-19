package com.filterrecipe.auth.repository;

import com.filterrecipe.auth.dto.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByLoginId(String loginId);

    Boolean existsByLoginId(String loginId);
}
