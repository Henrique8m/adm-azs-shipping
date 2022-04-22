package com.azship.api.input;

import com.azship.api.entities.Frete;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class MotoristaInput {

    private Long id;

    private String name;
    private String email;
    private String telefone;
    private String cpf;
    //    @OneToOne
    private List<Frete> fretes;

}
