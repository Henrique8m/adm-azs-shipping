package com.azship.api.resolvers.graphQL;

import com.azship.api.entities.Cliente;
import com.azship.api.entities.Endereco;
import com.azship.api.entities.Frete;
import com.azship.api.entities.Pacote;
import com.azship.api.servicies.ClienteService;
import com.azship.api.servicies.EnderecoService;
import com.azship.api.servicies.PacoteService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

    @Autowired
    private EnderecoService enderecoService;


    public List<Endereco> endereco(Cliente cliente){
        return enderecoService.findAllByCliente(cliente);
    }


}
