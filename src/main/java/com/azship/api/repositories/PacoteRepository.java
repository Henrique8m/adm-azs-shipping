package com.azship.api.repositories;


import com.azship.api.entities.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PacoteRepository extends JpaRepository<Pacote, Long> {
}
