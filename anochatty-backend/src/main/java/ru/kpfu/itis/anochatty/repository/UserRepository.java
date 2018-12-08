package ru.kpfu.itis.anochatty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.anochatty.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNickname(final String nickname);
}
