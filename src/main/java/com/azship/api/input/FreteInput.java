package com.azship.api.input;

import com.azship.api.entities.Cliente;
import com.azship.api.entities.Motorista;
import com.azship.api.entities.Pacote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class FreteInput {
    private Long id;
    private double custoPorKilo;
    private double custoDoFrete;
    private int notafiscal;
    private String observacao;
    private Cliente destinatario;
    private Cliente remetente;
    private List<Pacote> pacote = new ArrayList<>();
    private Motorista motorista;

}
