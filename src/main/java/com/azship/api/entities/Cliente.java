package com.azship.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "Tb_Clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinTable(name = "cliente_endereços",
    joinColumns = {
            @JoinColumn(name = "cliente_id",
            referencedColumnName = "id")},
    inverseJoinColumns = {
            @JoinColumn(name = "endereço_id",
            referencedColumnName = "id")})
    private List<Endereco> endereco;
    private String name;
    private String email;
    private String telefone;
    private String cpf;

}
