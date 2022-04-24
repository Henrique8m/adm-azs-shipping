package com.azship.api.input;

import com.azship.api.entities.Frete;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
public class PacoteInput {

    private Long id;
    private Frete frete;
    private double altura, largura, comprimento;
    private double peso;
    private Integer fatordecubagem;
    private Integer quantidade;

}
