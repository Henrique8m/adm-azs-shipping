package com.azship.api.resolvers.graphQL;

import com.azship.api.entities.Cliente;
import com.azship.api.entities.Frete;
import com.azship.api.entities.Pacote;
import com.azship.api.servicies.ClienteService;
import com.azship.api.servicies.PacoteService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FreteResolver implements GraphQLResolver<Frete> {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PacoteService pacoteService;

    public Cliente destinatario(Frete frete){
        return clienteService.findById(frete.getDestinatario().getId());
    }

    public Cliente remetente(Frete frete){
        return clienteService.findById(frete.getRemetente().getId());
    }

    public List<Pacote> pacote(Frete frete){

        return pacoteService.findAllByFrete(frete);
    }

}
