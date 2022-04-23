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
@Table(name = "Tb_Clientes")
public class Cliente implements Serializable {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telefone;
   // @JsonIgnore
    private String cpf;
   // @JsonIgnore
    private String cnpj;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> endereco = new ArrayList<>();

    @OneToMany
    @JsonIgnore
    private List<Frete> frete = new ArrayList<>();
}
