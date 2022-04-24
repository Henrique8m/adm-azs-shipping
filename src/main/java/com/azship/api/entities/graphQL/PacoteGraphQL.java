package com.azship.api.entities.graphQL;


import com.azship.api.entities.Cliente;
import com.azship.api.entities.Pacote;
import com.azship.api.input.ClienteInput;
import com.azship.api.input.PacoteInput;
import com.azship.api.servicies.ClienteService;
import com.azship.api.servicies.PacoteService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class PacoteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private PacoteService service;

    public Pacote pacote(Long id){
        return service.findById(id);
    }

    public List<Pacote> pacotes(){
       return service.findAll();
    }

    @Transactional
    public Pacote savePacote(PacoteInput pacoteInput ){
        ModelMapper map = new ModelMapper();
        Pacote pacote = map.map(pacoteInput,Pacote.class);
        return service.save(pacote);
    }

    @Transactional
    public Pacote updatedPacote(PacoteInput pacoteInput ){
        ModelMapper map = new ModelMapper();
        Pacote pacote = map.map(pacoteInput,Pacote.class);
        return service.save(pacote);
    }

    @Transactional
    public Boolean removerPacote(Long id){
        return service.deleteById(id);
    }
}
