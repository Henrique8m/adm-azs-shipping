package com.azship.api.entities.graphQL;


import com.azship.api.entities.Endereco;
import com.azship.api.entities.Frete;
import com.azship.api.entities.Pacote;
import com.azship.api.input.EnderecoInput;
import com.azship.api.input.FreteInput;
import com.azship.api.servicies.ClienteService;
import com.azship.api.servicies.EnderecoService;
import com.azship.api.servicies.FreteService;
import com.azship.api.servicies.PacoteService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class EnderecoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {



    @Autowired
    private EnderecoService enderecoService;

    public Endereco endereco(Long id){
        return enderecoService.findById(id);
    }

    public List<Endereco> enderecos(){
       return enderecoService.findAll();
    }

    @Transactional
    public Endereco saveEndereco(EnderecoInput enderecoInput ){
        Endereco endereco = new Endereco(
                enderecoInput.getCep(),
                enderecoInput.getRua(),
                enderecoInput.getNumero(),
                enderecoInput.getBairro(),
                enderecoInput.getCidade(),
                enderecoInput.getEstado(),
                enderecoInput.getPais()
        );
        if(enderecoInput.getComplemento()!=null){
            endereco.setComplemento(enderecoInput.getComplemento());
        }
        return enderecoService.save(endereco);
    }

    @Transactional
    public Endereco updatedEndereco(EnderecoInput enderecoInput ){
        Endereco endereco = enderecoService.findById(enderecoInput.getId());

        if( endereco.getCep() !=  enderecoInput.getCep() && enderecoInput.getCep() != null){
            endereco.setCep( enderecoInput.getCep() ); }
        if( endereco.getRua() !=  enderecoInput.getRua() && enderecoInput.getRua() != null){
            endereco.setRua( enderecoInput.getRua() );}
        if( endereco.getNumero() != enderecoInput.getNumero() && enderecoInput.getNumero() != null){
            endereco.setNumero( enderecoInput.getNumero() ); }
        if( endereco.getBairro() != enderecoInput.getBairro() && enderecoInput.getBairro() != null){
            endereco.setBairro( enderecoInput.getBairro()); }
        if( endereco.getCidade() !=  enderecoInput.getCidade() && enderecoInput.getCidade() != null){
            endereco.setCidade( enderecoInput.getCidade() ); }
        if( endereco.getEstado() != enderecoInput.getEstado() && enderecoInput.getEstado() != null){
            endereco.setEstado( enderecoInput.getEstado() ); }
        if( endereco.getPais() != enderecoInput.getPais() && enderecoInput.getPais() != null){
            endereco.setPais(enderecoInput.getPais()); }
        if( endereco.getComplemento() != enderecoInput.getComplemento() && enderecoInput.getComplemento() != null){
            endereco.setComplemento(enderecoInput.getComplemento()); }

        return enderecoService.save(endereco);
    }

    @Transactional
    public Boolean removerEndereco(Long id){
        return enderecoService.deleteById(id);
    }
}
