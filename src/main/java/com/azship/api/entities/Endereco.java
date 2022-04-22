package com.azship.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "Tb_Endereços")
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "cliente_endereços",
    joinColumns = {
            @JoinColumn(name = "endereço_id",
            referencedColumnName = "id")},
    inverseJoinColumns = {
            @JoinColumn(name = "cliente_id",
             referencedColumnName = "id")})
    private Cliente cliente;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;
    private String complemento;
}
