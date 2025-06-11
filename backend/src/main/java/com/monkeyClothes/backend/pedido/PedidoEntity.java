package com.monkeyClothes.backend.pedido;

import jakarta.persistence.*; // Puxa todas as anotações JPA usadas para mapear entidades e seus relacionamentos no banco de dados.
import lombok.Data; // Biblioteca que reduz a quantidade de código repetitivo, como getters e setters.
import java.time.LocalDateTime; // Importa a classe LocalDateTime da biblioteca padrão do Java. Ela representa data e hora juntas
import java.util.List; // Importa a interface List, usada para listas de objetos.

@Entity // Marca esta classe como uma entidade JPA
@Data // Gera getters, setters e outros métodos com Lombok
@Table(name = "pedido") // Define o nome da tabela como "pedido"
public class PedidoEntity {

    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID (auto-incremento)
    private Long id;

    @Column(name = "data_pedido", nullable = false) // Nome da coluna e campo obrigatório
    private LocalDateTime dataPedido; // Data e hora do pedido

    @Column(nullable = false) // Campo obrigatório
    private String status; // Status do pedido (ex: "PENDENTE", "ENVIADO")

    @ManyToOne // Muitos pedidos podem pertencer a uma compra
    @JoinColumn(name = "compra_id", referencedColumnName = "id") // Chave estrangeira para "compra"
    private CompraEntity compra; // Relacionamento com a entidade Compra

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL) // Um pedido pode ter vários produtos
    // "mappedBy = pedido" indica que o atributo "pedido" em ProdutoEntity é o dono da relação
    // "cascade = ALL" garante que as alterações em Pedido afetem também os produtos associados
    private List<ProdutoEntity> produtos; // Lista de produtos pertencentes a este pedido
}


