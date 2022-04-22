package com.azship.api.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProdutoInput {

    private Long id;
    private String quantidade;
    private String cubagem;
    private String formato;
    private String peso;
}
