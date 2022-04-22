package com.azship.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

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

    private String custo;
    private String nota;
    private String nome;
    private String cliente;

    @OneToMany(mappedBy = "frete")
    private List<Produto> produtos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "destinatario_id")
    private Endereco destinatario;


}
