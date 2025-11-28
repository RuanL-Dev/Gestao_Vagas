package br.com.ruangomes.gestao_vagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ruangomes.gestao_vagas.modules.company.dto.CreatJobDTO;
import br.com.ruangomes.gestao_vagas.modules.company.entities.JobEntity;
import br.com.ruangomes.gestao_vagas.modules.company.useCases.CreateJobUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    public JobEntity create (@Valid @RequestBody CreatJobDTO creatJobDTO, HttpServletRequest request) {
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
