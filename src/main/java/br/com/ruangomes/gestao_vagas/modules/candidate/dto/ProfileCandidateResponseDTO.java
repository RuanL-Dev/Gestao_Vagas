package br.com.ruangomes.gestao_vagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {
    
    @Schema(example = "Desenvolvedor Java")
    private String description;
    @Schema(example = "João")
    private String username;
    @Schema(example = "joao@example.com")
    private String email;
    private UUID id;
    @Schema(example = "João da Silva")
    private String name;
}
