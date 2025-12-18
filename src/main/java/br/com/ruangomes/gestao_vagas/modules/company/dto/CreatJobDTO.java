package br.com.ruangomes.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatJobDTO {

    @Schema(example = "Vaga para Desenvolvedor Junior", requiredMode = RequiredMode.REQUIRED)
    private String description;
    @Schema(example = "GYMPass, Plano de Saúde", requiredMode = RequiredMode.REQUIRED)
    private String benefits;
    @Schema(example = "Junior", requiredMode = RequiredMode.REQUIRED)
    private String level;

}
