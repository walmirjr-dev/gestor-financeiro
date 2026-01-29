# 💸 Financial Manager API

Este projeto é uma API REST desenvolvida para centralizar e organizar a gestão financeira pessoal. O foco principal é demonstrar o uso do **Spring Boot 3** e **Java 17**, aplicando padrões de projeto que garantam escalabilidade e fácil manutenção.

> **⚠️ Nota de Desenvolvimento:** Este projeto está em fase ativa de construção. A estrutura atual foca na base da arquitetura (Controller-Service-Repository) e nos princípios de Clean Code, servindo como base para as implementações avançadas listadas abaixo.

## 🚀 Práticas Implementadas
* **Camada de DTOs:** Uso de `Records` do Java 17 para transferência de dados segura e imutável.
* **Injeção de Dependências:** Uso rigoroso do ecossistema Spring para desacoplamento de classes.
* **Arquitetura Limpa:** Separação clara de responsabilidades entre as camadas do sistema (Controller -> Service -> Repository).

## 🛠️ Tecnologias
* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA**
* **H2 Database** (Persistência em memória para ambiente de desenvolvimento)
* **Maven**

---

## 🗺️ Próximos Passos

O projeto foi planejado para evoluir em etapas incrementais, adicionando complexidade técnica a cada sprint:

### ⚙️ Backend & Segurança
- [ ] **Bean Validation:** Implementação de validações via anotações (`@NotNull`, `@Min`, `@Email`) para garantir a integridade dos dados de entrada.
- [ ] **Autenticação com JWT:** Implementação de autenticação stateless utilizando JSON Web Tokens.
- [ ] **Segurança com Spring Security:** Proteção de endpoints e gerenciamento de perfis de acesso.
- [ ] **Banco de Dados Real:** Migração do banco H2 para um banco relacional robusto (PostgreSQL ou MySQL).

### 📈 Funcionalidades & Integrações
- [ ] **Simulador de Investimentos:** Integração com **API externa** para captura da taxa **SELIC** em tempo real, permitindo simulações de rendimento.
- [ ] **Módulo de Metas:** Lógica para reserva de valores focada em objetivos (ex: compra de carro).

### 🖥️ Frontend
- [ ] **Interface Web:** Desenvolvimento de um frontend responsivo utilizando **React** para consumo da API.
