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
@Table(name = "Tb_Motoristas")
public class Motorista implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String telefone;
    private String cpf;
    //    @OneToOne
    private String fretes;

}
