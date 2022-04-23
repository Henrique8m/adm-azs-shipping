package com.azship.api.input;

import com.azship.api.entities.Endereco;
import com.azship.api.entities.Frete;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class ClienteInput {
    private Long id;
    private String name;
    private String email;
    private String telefone;
    private String cpf;
    private String cnpj;
    private List<Endereco> endereco = new ArrayList<>();
    private List<Frete> frete = new ArrayList<>();
}
