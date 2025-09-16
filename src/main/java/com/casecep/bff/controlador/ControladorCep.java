package com.casecep.bff.controlador;

import com.casecep.bff.dto.RespostaEndereco;
import com.casecep.bff.servico.ServicoCep;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorCep {

    private final ServicoCep servicoCep;

    public ControladorCep(ServicoCep servicoCep) {
        this.servicoCep = servicoCep;
    }

    @GetMapping("/enderecos/{cep}")
    public RespostaEndereco obterEndereco(@PathVariable String cep) {
        return servicoCep.buscarEndereco(cep);
    }
}
