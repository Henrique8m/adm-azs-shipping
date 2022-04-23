package com.azship.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "Tb_Fretes")
public class Frete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private double custoporkilo;
    private double custodofrete;
    private int notafiscal;
    private String observacao;

    @OneToOne
    private Cliente destinatario;
    @OneToOne
    private Cliente remetente;
    @OneToMany(mappedBy = "frete",fetch = FetchType.EAGER)
    private List<Pacote> pacote = new ArrayList<>();
    @OneToOne(mappedBy = "frete")
    private Motorista motorista;

    public Double getCustoDoFrete(){

        if(custoporkilo==0)custoporkilo=5d;
        Double custo = 0d;
        Double pesoCalculado = 0d;
        for(com.azship.api.entities.Pacote list: pacote){

            int quant =  list.getQuantidade();
            Double peso = list.getPesoFinal();
            pesoCalculado += peso * quant;

        }
        while(pesoCalculado>1d){
            pesoCalculado -= 1d;
            custo += 1 * custoporkilo;
        }
        return custo;
    }
}
