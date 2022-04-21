package com.azship.api.servicies;

import com.azship.api.entities.Frete;
import com.azship.api.repositories.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FreteService {

    @Autowired
    private FreteRepository repository;

    public Frete findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Frete> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Frete save(Frete frete){
        return repository.save(frete);
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

