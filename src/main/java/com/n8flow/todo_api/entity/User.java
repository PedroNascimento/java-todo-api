package com.n8flow.todo_api.entity;

/* Importa a especificação oficial do Java (JPA - Jakarta Persistence).
É aqui que vêm as anotações como @Entity, @Id, @Column e os relacionamentos
*/
import jakarta.persistence.*;

/*Importa os modificadores de código em tempo de compilação da biblioteca Lombok,
que vão gerar os códigos repetitivos (boilercodes) automaticamente.*/
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Importa recursos específicos do Hibernate (que é o motor que roda por baixo do JPA) para cuidar de carimbos de data/hora automaticamente.
import org.hibernate.annotations.CreationTimestamp;


/*Importações nativas do Java para manipulação de datas modernas com fuso horário
local e suporte para identificadores únicos universais de 128 bits.*/
import java.time.LocalDateTime;
import java.util.UUID;

/*
Decorações da Classe (Anotações de Topo)

Essas anotações transformam uma classe Java comum (POJO) em um
componente gerenciável de banco de dados e geram infraestrutura de código.*/

@Entity //Diz ao Spring Data JPA: "Guarde esta classe, ela representa uma tabela física no banco de dados"
@Table(name = "users") //Mapeia explicitamente o nome exato da tabela no PostgreSQL. Garante que a classe User converse com a tabela users que o Flyway criou

/*@Getter e @Setter
O Lombok gera todos os métodos getId(), setId(), getTitle(), etc.,
em tempo de compilação, mantendo o arquivo visualmente limpo.*/
@Getter
@Setter

/*implementa o padrão de projeto Builder.
Permite que você crie instâncias da classe de forma super elegante no seu código:
User.builder().name("Pedro").email("...").build();*/
@Builder

@NoArgsConstructor //Gera o construtor vazio obrigatório pelo Hibernate para conseguir instanciar a classe ao buscar dados do banco.
@AllArgsConstructor //Gera o construtor com todos os campos, exigido para o funcionamento correto do @Builder.

public class User {
    @Id //Define que esse atributo é a Chave Primária (Primary Key) da tabela.

    /*Instruirá o framework a gerar um identificador UUID único de forma automática
    no momento do salvamento, eliminando a previsibilidade de ids sequenciais (1, 2, 3...)
    por motivos de segurança.*/
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


}
