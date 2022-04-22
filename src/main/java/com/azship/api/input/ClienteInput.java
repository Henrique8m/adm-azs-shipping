package com.azship.api.input;

import com.azship.api.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class ClienteInput {

    private Long id;
    private String name;
    private String email;
    private String telefone;
    private String cpf;
//    @OneToOne
    private Endereco endereco;
}
