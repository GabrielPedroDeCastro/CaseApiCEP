package com.casecep.bff.servico;

import com.casecep.bff.dto.RespostaEndereco;
import com.casecep.bff.dto.RespostaViaCep;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicoCep {

    private final RestTemplate restTemplate;

    public ServicoCep(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public RespostaEndereco buscarEndereco(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        RespostaViaCep resposta = restTemplate.getForObject(url, RespostaViaCep.class);

        if (resposta == null) {
            throw new RuntimeException("CEP não encontrado.");
        }

        return new RespostaEndereco(
                resposta.getCep(),
                resposta.getLogradouro() != null ? resposta.getLogradouro().toLowerCase() : null,
                resposta.getComplemento(),
                resposta.getBairro(),
                resposta.getLocalidade(),
                resposta.getUf() 
        );
    }
}
