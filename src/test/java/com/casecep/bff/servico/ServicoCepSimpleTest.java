package com.casecep.bff.servico;

import com.casecep.bff.dto.RespostaEndereco;
import com.casecep.bff.dto.RespostaViaCep;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class ServicoCepSimpleTest {

    // Stub simples sem Mockito — fácil de rodar com mvnw.cmd test
    static class FakeRestTemplate extends RestTemplate {
        @Override
        public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) {
            if ("https://viacep.com.br/ws/01001000/json/".equals(url)) {
                RespostaViaCep viaCep = new RespostaViaCep();
                viaCep.setCep("01001-000");
                viaCep.setLogradouro("Praça da Sé");
                viaCep.setComplemento("lado ímpar");
                viaCep.setBairro("Sé");
                viaCep.setLocalidade("São Paulo");
                viaCep.setUf("SP");
                return responseType.cast(viaCep);
            }
            return null;
        }
    }

    @Test
    void buscarEndereco_simples_semMockito() {
        RestTemplate restTemplate = new FakeRestTemplate();
        ServicoCep servico = new ServicoCep(restTemplate);

        RespostaEndereco resultado = servico.buscarEndereco("01001000");

        assertNotNull(resultado);
        assertEquals("01001-000", resultado.getCep());
        assertEquals("praça da sé", resultado.getLogradouro());
        assertEquals("lado ímpar", resultado.getComplemento());
        assertEquals("Sé", resultado.getBairro());
        assertEquals("São Paulo", resultado.getLocalidade());
        assertEquals("SP", resultado.getUf());
    }
}