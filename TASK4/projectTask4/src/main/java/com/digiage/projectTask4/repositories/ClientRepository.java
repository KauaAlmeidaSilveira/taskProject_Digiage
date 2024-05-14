package com.digiage.projectTask4.repositories;

import com.digiage.projectTask4.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
