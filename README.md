# Case Técnico - Consulta de CEP (ViaCEP) - Versão Português

Este repositório contém o **BFF em Java + Spring Boot** que consome a API pública [ViaCEP](https://viacep.com.br/), remove campos desnecessários (IBGE, GIA, DDD e Siafi) e retorna o **logradouro em lowercase**.

## Estrutura do Projeto
```
src/main/java/com/casecep/bff
│
├── AplicacaoCepBff.java         # Classe principal (main)
├── configuracao/ConfiguracaoRest.java
├── controlador/ControladorCep.java
├── dto/RespostaEndereco.java
├── dto/RespostaViaCep.java
└── servico/ServicoCep.java
```

## Requisitos
- Java 17
- Maven
- Internet ativa (para acessar `https://viacep.com.br`)

## Como rodar
1. Compilar e executar:
```bash
mvn spring-boot:run
```

2. Testar o endpoint:
```
GET http://localhost:8080/enderecos/01001000
```

## Exemplo de resposta
```json
{
  "cep": "01001-000",
  "logradouro": "praça da sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
}
```

## Observações
- Os campos `ibge`, `gia`, `ddd` e `siafi` presentes na resposta do ViaCEP não são repassados pelo BFF.
- O campo `logradouro` é convertido para **lowercase** antes de ser retornado.

## .gitignore
O projeto já inclui um `.gitignore` com entradas básicas para Java/Maven.

## Autor
Desenvolvido por você — sinta-se à vontade para personalizar o README com seu nome e instruções adicionais.
