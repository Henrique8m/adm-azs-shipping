package com.azship.api.input;

import com.azship.api.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class FreteInput {

    private Long id;
    private String custo;
    private String nota;
    private String nome;
    private String cliente;

    private Endereco destinatario;
    private String produtos;

}
