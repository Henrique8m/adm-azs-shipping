package com.azship.api.graphQL;


import com.azship.api.entities.Cliente;
import com.azship.api.input.ClienteInput;
import com.azship.api.servicies.ClienteService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService service;

    public Cliente cliente(Long id){
        return service.findById(id);
    }

    public List<Cliente> clientes(){
       return service.findAll();
    }

    @Transactional
    public Cliente saveCliente(ClienteInput clienteInput ){
        ModelMapper map = new ModelMapper();
        Cliente cliente = map.map(clienteInput,Cliente.class);
        return service.save(cliente);
    }

    @Transactional
    public Cliente updatedCliente(ClienteInput clienteInput ){
        ModelMapper map = new ModelMapper();
        Cliente cliente = map.map(clienteInput,Cliente.class);
        return service.save(cliente);
    }

    @Transactional
    public Boolean removerCliente(Long id){
        return service.deleteById(id);
    }
}
