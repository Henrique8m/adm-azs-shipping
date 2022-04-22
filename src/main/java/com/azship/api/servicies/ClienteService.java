package com.azship.api.servicies;

import com.azship.api.entities.Cliente;
import com.azship.api.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Cliente> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Cliente save(Cliente cliente){
        return repository.save(cliente);
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

