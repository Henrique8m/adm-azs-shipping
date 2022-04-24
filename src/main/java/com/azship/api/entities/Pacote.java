package com.azship.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
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
    private double pesofinal;

    public String getMetadado() {
        String str = "";
        try {
            if( (altura!=null)&&(largura!=null)&&(comprimento!=null)&&(peso!=null) ) {
                double cubico = altura * largura * comprimento;
                str = cubico + " m³," + this.peso + " Kg";
                return str;
            }else if(peso!=null){
                str = this.peso + " Kg";
                return str;
            }else{

                double cubico = altura * largura * comprimento;
                str = cubico + " m³";
                return str;

            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        return str;
    }

    public double getPesofinal(){

        if(fatordecubagem==null)this.fatordecubagem=6000;
        if( (altura!=null)&&(largura!=null)&&(comprimento!=null)) {

            double pesoCubico = (altura * largura * comprimento)/fatordecubagem;
            if( (peso!=null)&&(peso>pesoCubico) ){
                return peso;
            }else if( (peso!=null)&&(peso<pesoCubico) ){
                return pesoCubico;
            }else return pesoCubico;

        }else return peso;
    }

    public Long getId() {
        return id;
    }

    public Frete getFrete() {
        return frete;
    }

    public Double getAltura() {
        return altura;
    }

    public Double getLargura() {
        return largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getFatordecubagem() {
        if(fatordecubagem==null)
            this.fatordecubagem=6000;
        return fatordecubagem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacote pacote = (Pacote) o;
        return Objects.equals(id, pacote.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
