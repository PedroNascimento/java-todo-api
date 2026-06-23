package com.n8flow.todo_api.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity //Diz ao Spring Data JPA: "Guarde esta classe, ela representa uma tabela física no banco de dados"
@Table(name = "users") //Mapeia explicitamente o nome exato da tabela no PostgreSQL. Garante que a classe User converse com a tabela users que o Flyway criou

@Getter
@Setter
@Builder

@NoArgsConstructor //Gera o construtor vazio obrigatório pelo Hibernate para conseguir instanciar a classe ao buscar dados do banco.
@AllArgsConstructor //Gera o construtor com todos os campos, exigido para o funcionamento correto do @Builder.

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /*@Column(nullable = false): Traduz-se para NOT NULL no banco. Impede o salvamento de registros sem essa informação.
      unique = true (no Email): Cria uma restrição de unicidade no banco.
      O banco rejeitará se tentarem cadastrar dois usuários com o mesmo e-mail.*/

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public java.util.UUID getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }


}
