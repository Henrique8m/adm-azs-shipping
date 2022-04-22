package com.azship.api.servicies;

import com.azship.api.entities.Produto;
import com.azship.api.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Produto save(Produto produto){
        return repository.save(produto);
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

