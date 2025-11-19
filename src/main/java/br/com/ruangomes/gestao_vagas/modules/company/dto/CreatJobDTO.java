package br.com.ruangomes.gestao_vagas.modules.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatJobDTO {

    private String description;
    private String benefits;
    private String level;
    
}
