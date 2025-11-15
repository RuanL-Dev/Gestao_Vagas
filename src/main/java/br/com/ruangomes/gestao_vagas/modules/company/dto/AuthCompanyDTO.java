package br.com.ruangomes.gestao_vagas.modules.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //Encapsula a criação do construtor com todos os atributos
public class AuthCompanyDTO {
    
    private String password;
    private String username;
}
