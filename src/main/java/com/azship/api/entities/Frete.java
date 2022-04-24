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

    public Frete(float custoporkilo, int notafiscal, Cliente destinatario, Cliente remetente) {
        this.custoporkilo = custoporkilo;
        this.notafiscal = notafiscal;
        this.destinatario = destinatario;
        this.remetente = remetente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private float custoporkilo;
    private float custodofrete;
    private int notafiscal;
    private String observacao;

    @OneToOne(fetch = FetchType.LAZY)
    private Cliente destinatario;
    @OneToOne(fetch = FetchType.LAZY)
    private Cliente remetente;
    @OneToMany(mappedBy = "frete", fetch = FetchType.EAGER)
    private List<Pacote> pacote = new ArrayList<>();

    public double getCustodofrete(){

        if(custoporkilo==0)custoporkilo=5;
        double custo = 0d;
        double pesoCalculado = 0d;
        for(Pacote list: pacote){

            int quant =  list.getQuantidade();
            double peso = list.getPesofinal();
            pesoCalculado += peso * quant;

        }
        while(pesoCalculado>1d){
            pesoCalculado -= 1d;
            custo += 1 * custoporkilo;
        }
        return custo;
    }
}
