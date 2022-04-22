package com.azship.api.graphQL;


import com.azship.api.entities.Frete;
import com.azship.api.input.FreteInput;
import com.azship.api.servicies.FreteService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class FreteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private FreteService service;

    public Frete frete(Long id){
        return service.findById(id);
    }

    public List<Frete> fretes(){
       return service.findAll();
    }

    @Transactional
    public Frete save(FreteInput freteInput ){
        ModelMapper map = new ModelMapper();
        Frete frete = map.map(freteInput,Frete.class);
        return service.save(frete);
    }

    @Transactional
    public Frete updated(FreteInput freteInput ){
        ModelMapper map = new ModelMapper();
        Frete frete = map.map(freteInput,Frete.class);
        return service.save(frete);
    }

    @Transactional
    public Boolean deletePortage(Long id){
        return service.deleteById(id);
    }
}
