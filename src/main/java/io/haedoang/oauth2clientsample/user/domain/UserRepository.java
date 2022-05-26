package io.haedoang.oauth2clientsample.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * packageName : io.haedoang.secure.user.domain
 * fileName : UserRepository
 * author : haedoang
 * date : 2022-05-26
 * description :
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
