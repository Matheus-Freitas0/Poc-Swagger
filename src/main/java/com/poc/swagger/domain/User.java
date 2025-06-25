package com.poc.swagger.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@Schema(description = "Entidade que representa um usuário no sistema")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do usuário", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Nome completo do usuário", example = "João da Silva")
    private String name;

    @Schema(description = "Email do usuário", example = "joao.silva@email.com")
    private String email;
}
