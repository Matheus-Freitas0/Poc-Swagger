package com.poc.swagger.controller;

import com.poc.swagger.domain.User;
import com.poc.swagger.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Usuários", description = "Operações relacionadas a usuários")
@RestController
@RequestMapping("/api/swagger")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Buscar usuário por ID", description = "Retorna um usuário baseado no ID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(
            @Parameter(description = "ID do usuário", example = "1") @PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUserName(id));
    }

    @Operation(summary = "Listar todos os usuários", description = "Retorna a lista de todos os usuários cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @Operation(summary = "Deletar um usuário", description = "Deleta um usuário baseado no ID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(
            @Parameter(description = "ID do usuário", example = "1") @PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Criar novo usuário", description = "Cria um novo usuário com os dados fornecidos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping("/user")
    public ResponseEntity<User> createUser(
            @RequestBody(
                    description = "Objeto do usuário a ser criado",
                    required = true,
                    content = @Content(schema = @Schema(implementation = User.class))
            )
            @org.springframework.web.bind.annotation.RequestBody User user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

        @Operation(summary = "Atualizar dados do usuário", description = "Atualiza os dados de um usuário existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @PutMapping("/user/update/{id}")
    public ResponseEntity<User> updateUser(
            @Parameter(description = "ID do usuário a ser atualizado", example = "1") @PathVariable Long id,
            @RequestBody(
                    description = "Novos dados do usuário",
                    required = true,
                    content = @Content(schema = @Schema(implementation = User.class))
            )
            @org.springframework.web.bind.annotation.RequestBody User userDetails) {
        return ResponseEntity.ok().body(userService.updateUser(userDetails, id));
    }
}
