package com.azship.api.repositories;


import com.azship.api.entities.Frete;
import com.azship.api.entities.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface PacoteRepository extends JpaRepository<Pacote, Long> {
    List<Pacote> findAllByFrete(Frete frete);

}
