package com.azship.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Tb_Pacote")
public class Pacote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne
    private Frete frete;
    @JsonIgnore
    private Double altura, largura, comprimento;
    @JsonIgnore
    private Double peso;
    @JsonIgnore
    private Integer fatordecubagem;
    private Integer quantidade;
    private String metadado;
    private Double pesoFinal;

    public String getMetadado() {
        String str;
        if( (altura!=null)&&(largura!=null)&&(comprimento!=null)&&(peso!=null) ) {
            double cubico = altura * largura * comprimento;
            str = Double.toString(cubico) + " m³," + Double.toString(this.peso) + " Kg";
            return str;
        }else if(peso!=null){
            str = Double.toString(this.peso) + " Kg";
            return str;
        }else{
            double cubico = altura * largura * comprimento;
            str = Double.toString(cubico) + " m³";
            return str;
        }
    }

    public Double getPesoFinal(){

        if(fatordecubagem==null)fatordecubagem=6000;
        if( (altura!=null)&&(largura!=null)&&(comprimento!=null)) {

            double pesoCubico = (altura * largura * comprimento)/fatordecubagem;
            if( (peso!=null)&&(peso>pesoCubico) ){
                return peso;
            }else if( (peso!=null)&&(peso<pesoCubico) ){
                return pesoCubico;
            }else return pesoCubico;

        }else return peso;
    }
    public void setPesoFinal(){}
    public void setMetadado(){}

}
