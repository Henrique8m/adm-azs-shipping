package com.azship.api.servicies;

import com.azship.api.entities.Frete;
import com.azship.api.entities.Pacote;
import com.azship.api.repositories.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository repository;


    public Pacote findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Pacote> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Pacote save(Pacote pacote){
        return repository.save(pacote);
    }

    @Transactional
    public Boolean deleteById(Long id){
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Pacote> findAllByFrete(Frete frete) {
        return repository.findAllByFrete(frete);
    }

    public List<Pacote> findAllById(List<Long> id) {
        return repository.findAllById(id);
    }

}

