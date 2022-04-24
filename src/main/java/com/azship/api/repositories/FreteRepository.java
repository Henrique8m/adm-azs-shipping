package com.azship.api.repositories;


import com.azship.api.entities.Cliente;
import com.azship.api.entities.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface FreteRepository extends JpaRepository<Frete, Long> {
}
