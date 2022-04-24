package com.azship.api.entities.graphQL;


import com.azship.api.entities.Cliente;
import com.azship.api.entities.Endereco;
import com.azship.api.entities.Frete;
import com.azship.api.input.ClienteInput;
import com.azship.api.servicies.ClienteService;
import com.azship.api.servicies.EnderecoService;
import com.azship.api.servicies.FreteService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private FreteService freteService;

    public Cliente cliente(Long id){
        return clienteService.findById(id);
    }

    public List<Cliente> clientes(){
       return clienteService.findAll();
    }

    @Transactional
    public Cliente saveCliente(ClienteInput clienteInput ){
        List<Long> enderecoId = clienteInput.getEnderecos();
        List<Endereco> enderecos = new ArrayList<>();
        for(Long listId: enderecoId){
            enderecos.add( enderecoService.findById( listId ));
        }
        clienteInput.setEndereco(enderecos);
        ModelMapper map = new ModelMapper();
        Cliente cliente = map.map(clienteInput,Cliente.class);
        for(Endereco listId: enderecos){
            enderecoService.findById( listId.getId() ).setCliente(cliente);
        }

        return clienteService.save(cliente);
    }

    @Transactional
    public Cliente updatedCliente(ClienteInput clienteInput ){
        List<Endereco> enderecos = new ArrayList<>();
        if(clienteInput.getEnderecos() != null){
            List<Long> enderecoId = clienteInput.getEnderecos();

            for(Long listId: enderecoId){
                enderecos.add( enderecoService.findById( listId ));
            }
            clienteInput.setEndereco(enderecos);
        }
        ModelMapper map = new ModelMapper();
        Cliente cliente = map.map(clienteInput,Cliente.class);

        if(enderecos!=null){
            List<Endereco> listOld = enderecoService.findAllByCliente(cliente);
            for(Endereco list: listOld) {
                    list.setCliente(null);
            }
            for(Endereco listId: enderecos){
                enderecoService.findById( listId.getId() ).setCliente(cliente);
            }
        }

        return clienteService.save(cliente);
    }

    @Transactional
    public Boolean removerCliente(Long id){
        return clienteService.deleteById(id);
    }
}
