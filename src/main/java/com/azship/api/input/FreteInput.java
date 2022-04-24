package com.azship.api.input;

import com.azship.api.servicies.ClienteService;
import com.azship.api.servicies.PacoteService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class FreteInput {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PacoteService pacoteService;

    private Long id;
    private float custoporkilo;
    private float custodofrete;
    private int notafiscal;
    private String observacao;
    private Long destinatario;
    private Long remetente;
    private List<Long> pacote;
    private Long motorista;

}
