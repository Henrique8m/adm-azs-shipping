package com.azship.api.input;

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
//    private Cliente cliente;
    private String destinatario;
//    private List<Produto> produtos;

}
