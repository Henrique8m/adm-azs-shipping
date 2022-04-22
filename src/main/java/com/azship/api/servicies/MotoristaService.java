package com.azship.api.servicies;

import com.azship.api.entities.Motorista;
import com.azship.api.repositories.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository repository;

    public Motorista findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Motorista> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Motorista save(Motorista motorista){
        return repository.save(motorista);
    }

    @Transactional
    public Boolean deleteById(Long id){
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

