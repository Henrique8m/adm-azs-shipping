package com.azship.api.servicies;

import com.azship.api.entities.Endereco;
import com.azship.api.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Endereco> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Endereco save(Endereco endereco){
        return repository.save(endereco);
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

