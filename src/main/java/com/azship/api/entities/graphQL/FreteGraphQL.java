package com.azship.api.entities.graphQL;


import com.azship.api.entities.Frete;
import com.azship.api.entities.Pacote;
import com.azship.api.input.FreteInput;
import com.azship.api.servicies.ClienteService;
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
public class FreteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private FreteService freteService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PacoteService pacoteService;


    public Frete frete(Long id){
        return freteService.findById(id);
    }

    public List<Frete> fretes(){
       return freteService.findAll();
    }

    @Transactional
    public Frete saveFrete(FreteInput freteInput ){
        List<Pacote> pacotes = new ArrayList<>();
        for( Long pacoteid: freteInput.getPacote()){
            pacotes.add(pacoteService.findById(pacoteid) );
        }
        Frete frete = new Frete(
                freteInput.getCustoporkilo(),
                freteInput.getNotafiscal(),
                clienteService.findById(freteInput.getDestinatario()),
                clienteService.findById(freteInput.getRemetente()));
        if(freteInput.getObservacao()!=null)
            frete.setObservacao(freteInput.getObservacao());
        frete.setPacote(pacotes);
        for( Pacote pacoteid: pacotes){
            Pacote pac = pacoteService.findById(pacoteid.getId());
            pac.setFrete(frete);
        }

        return freteService.save(frete);
    }

    @Transactional
    public Frete updatedFrete(FreteInput freteInput ){
        Frete frete = freteService.findById(freteInput.getId());

            if(freteInput.getCustoporkilo() != frete.getCustoporkilo()){ frete.setCustoporkilo( freteInput.getCustoporkilo() ); }
            if(freteInput.getNotafiscal() != frete.getNotafiscal()){ frete.setNotafiscal( freteInput.getNotafiscal() ); }
            if(freteInput.getObservacao() != frete.getObservacao()){ frete.setObservacao( freteInput.getObservacao() ); }
            if(clienteService.findById(freteInput.getDestinatario()) != frete.getDestinatario()){
                frete.setDestinatario( clienteService.findById(freteInput.getDestinatario()) ); }
            if(clienteService.findById(freteInput.getRemetente()) != frete.getRemetente()){
                frete.setRemetente( clienteService.findById(freteInput.getRemetente()) ); }

        //Limpar memoria de pacotes para receber os novos que veio na atualização
        if(freteInput.getPacote()!=null){

            List<Pacote> pacotesRemover = pacoteService.findAllByFrete(frete);
            for( Pacote pacote: pacotesRemover){
                pacote.setFrete(null);
                pacoteService.save(pacote);
            }

            frete.setPacote(new ArrayList<>());

            List<Pacote> pacotes = new ArrayList<>();
            for( Long pacoteid: freteInput.getPacote()){
                pacotes.add(pacoteService.findById(pacoteid) );
            }
            for( Pacote pacoteid: pacotes){
                Pacote pac = pacoteService.findById(pacoteid.getId());
                pac.setFrete(frete);
            }
        }

        return freteService.save(frete);
    }

    @Transactional
    public Boolean removerFrete(Long id){
        return freteService.deleteById(id);
    }
}
