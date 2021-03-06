package com.azship.api.repositories;


import com.azship.api.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
