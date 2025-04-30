# Monkey-Clothes
Repositório backend do projeto MonkeyClothes

# 📦Diagrama de Pacotes
O projeto usará uma organização de pacotes por domínio, usando como base as entidades criadas no diagrama conceitual do banco de dados.

Abaixo o diagrama de pacotes modelo do projeto:

```text
br.com.MonkeyClothes
├── cliente
│ ├── ClienteController.java
│ ├── ClienteService.java
│ ├── ClienteRepository.java
│ └── ClienteEntity.java
│
├── compra
│ ├── CompraController.java
│ ├── CompraService.java
│ ├── CompraRepository.java
│ └── CompraEntity.java
│
├── pagamento
│ ├── PagamentoController.java
│ ├── PagamentoService.java
│ ├── PagamentoRepository.java
│ └── PagamentoEntity.java
│
├── pedido
│ ├── PedidoController.java
│ ├── PedidoService.java
│ ├── PedidoRepository.java
│ └── PedidoEntity.java
│
└── produto
  ├── ProdutoController.java
  ├── ProdutoService.java
  ├── ProdutoRepository.java
  └── ProdutoEntity.java
```
# 🔗Dependências
O projeto utiliza o gerenciador de dependências **Maven**, as bibliotecas usadas estão localizadas no arquivo `backend/pom.xml`. A seguir estão as bibliotecas utilizadas no projeto:
## Spring Boot DevTools
* Providência rápidas atualizações da aplicação
* Atulização em tempo real
* Configurações para uma melhor experiência de desenvolvimento
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```
## Spring Web
* Permite construção de aplicações web com REST
* Utiliza spring MVC para as aplicações
* Utiliza o Apache Tomcat como servidor web padrão
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```