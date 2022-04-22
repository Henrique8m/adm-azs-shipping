package com.azship.api;

import com.azship.api.entities.Cliente;
import com.azship.api.entities.Endereco;
import com.azship.api.entities.Frete;
import com.azship.api.repositories.ClienteRepository;
import com.azship.api.repositories.EnderecoRepository;
import com.azship.api.repositories.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    private ClienteRepository repositoryCL;

    @Autowired
    private FreteRepository repositoryFrete;

    @GetMapping
    public ResponseEntity<Endereco> findByIdEndereco(){
        return ResponseEntity.ok(repository.findById(1l).get());
    }
    @GetMapping(value = {"cliente"})
    public ResponseEntity<Cliente> findByIdCliente(){
        return ResponseEntity.ok(repositoryCL.findById(1l).get());
    }

    @GetMapping(value = {"frete"})
    public ResponseEntity<Frete> findByIdFrete(){
        return ResponseEntity.ok(repositoryFrete.findById(1l).get());
    }
}
