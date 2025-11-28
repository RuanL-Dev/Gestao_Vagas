package br.com.ruangomes.gestao_vagas.modules.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // serve para gerar os getters e setters automaticamente
@Builder // serve para criar um padrão de projeto chamado "Builder", que facilita a
         // criação de objetos
@NoArgsConstructor // serve para gerar um construtor sem argumentos
@AllArgsConstructor // serve para gerar um construtor com todos os argumentos
public class AuthCompanyResponseDTO {
    private String access_token;
    private Long expires_in;
}
