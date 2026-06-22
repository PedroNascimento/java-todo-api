package com.n8flow.todo_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    /*columnDefinition = "TEXT" (na Description): Altera o tipo do banco de VARCHAR(255) para TEXT,
    permitindo que o usuário escreva descrições longas para a tarefa sem estourar o limite de caracteres.*/
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private boolean completed; //Mapeia diretamente para um campo BOOLEAN no banco de dados.


    /*Define a cardinalidade. Muitas (Many) tarefas podem pertencer a Um (One) usuário único.
      fetch = FetchType.LAZY: Configuração crucial de performance.
      Diz para o Hibernate só buscar os dados do usuário no banco se o seu código
      explicitamente chamar task.getUser(). Isso evita consultas pesadas
      e desnecessárias (o famoso problema N+1).*/
    @ManyToOne(fetch = FetchType.LAZY, optional = false)

    /*@JoinColumn(name = "user_id"):
    Cria a coluna de Chave Estrangeira (Foreign Key)
    física na tabela de tarefas, apontando de volta para a tabela de usuários.*/
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /*O Hibernate captura a data e hora exata do relógio do sistema no
    milissegundo em que o registro é inserido no banco pela primeira vez e injeta no campo.*/
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    /*Monitorea a entidade. Sempre que qualquer campo da
    tarefa sofrer um UPDATE no banco, o Hibernate atualiza este campo automaticamente para o horário atual.*/
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
