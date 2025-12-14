package br.com.ruangomes.gestao_vagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ruangomes.gestao_vagas.exceptions.JobNotFoundException;
import br.com.ruangomes.gestao_vagas.exceptions.UserNotFoundException;
import br.com.ruangomes.gestao_vagas.modules.candidate.repositories.ApplyJobRepository;
import br.com.ruangomes.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import br.com.ruangomes.gestao_vagas.modules.company.repositories.JobRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplyJobCandidateUseCase {

    private final CandidateRepository candidateRepository;

    private final JobRepository jobRepository;

    private final ApplyJobRepository applyJobRepository;

    public void execute(UUID idCandidate, UUID idJob) {
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        this.jobRepository.findById(idJob)
                .orElseThrow(() -> {
                    throw new JobNotFoundException();
                });
    }
}
