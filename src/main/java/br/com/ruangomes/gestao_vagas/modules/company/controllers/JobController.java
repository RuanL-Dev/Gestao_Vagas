package br.com.ruangomes.gestao_vagas.modules.company.controllers;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ruangomes.gestao_vagas.modules.company.dto.CreatJobDTO;
import br.com.ruangomes.gestao_vagas.modules.company.entities.JobEntity;
import br.com.ruangomes.gestao_vagas.modules.company.useCases.CreateJobUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/company/job")
@Tag(name = "Vagas", description = "Informações das vagas")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    @Operation(summary = "Cadastro de vaga", description = "Essa função é responsável por cadastrar as vagas dentro da empresa.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = JobEntity.class))
            })
    })
    @SecurityRequirement(name = "jwt_auth")
    public JobEntity create(@Valid @RequestBody CreatJobDTO creatJobDTO, HttpServletRequest request) {
        var companyId = request.getAttribute("company_id").toString();

        var jobEntity = JobEntity.builder()
                .description(creatJobDTO.getDescription())
                .benefits(creatJobDTO.getBenefits())
                .level(creatJobDTO.getLevel())
                .companyId(UUID.fromString(companyId))
                .build();
        return this.createJobUseCase.execute(jobEntity);

    }
}
