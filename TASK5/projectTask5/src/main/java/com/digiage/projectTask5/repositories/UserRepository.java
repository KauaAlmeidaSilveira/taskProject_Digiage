package com.digiage.projectTask5.repositories;

import com.digiage.projectTask5.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
