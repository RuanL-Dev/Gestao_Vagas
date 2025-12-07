package br.com.ruangomes.gestao_vagas.modules.candidate.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "João da Silva", requiredMode = RequiredMode.REQUIRED, description = "Nome do candidato.")
    private String name;

    @NotBlank(message = "O campo [username] é obrigatório.")
    @Pattern(regexp = "^[^\\s]+$", message = "O campo [username] não deve conter espaços em branco.")
    @Schema(example = "joaosilva", requiredMode = RequiredMode.REQUIRED, description = "Nome de usuário do candidato - não deve conter espaços em branco.")
    private String username;

    @Email(message = "O campo [email] deve conter um endereço de email válido.")
    @Schema(example = "joao.silva@example.com", requiredMode = RequiredMode.REQUIRED, description = "Endereço de email do candidato.")
    private String email;

    @Length(min = 10, max = 100, message = "A senha [password] deve conter entre (10) e (100) caracteres.")
    @Schema(example = "admin@12345", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED, description = "Senha do candidato - deve conter entre (10) e (100) caracteres.")
    private String password;

    @Schema(example = "Desenvolvedor Full Stack com 5 anos de experiência em Java e React.", requiredMode = RequiredMode.NOT_REQUIRED, description = "Breve descrição do candidato.")
    private String description;

    @Schema(example = "http://linkedin.com/in/joaosilva")
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
}
