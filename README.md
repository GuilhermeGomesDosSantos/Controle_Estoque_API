# 🧾 API de Estoque de Produtos

Esta API foi desenvolvida para gerenciar o **estoque de produtos**, oferecendo operações completas de **CRUD (Create, Read, Update, Delete)**.  
O sistema conta com **autenticação via token** e **controle de acesso baseado em funções (roles)**, garantindo segurança e integridade nas operações.


## 🚀 Tecnologias Utilizadas

- **Linguagem:** Java ☕  
- **Framework:** Spring Boot 🌱  
- **Autenticação:** OAuth 2.0 + JWT  
- **Banco de Dados:** MySQL (gerenciado via **MySQL Workbench**)  
- **Persistência de Dados:** Spring Data JPA

---

## 🧩 Instruções de Instalação

### 🔧 Pré-requisitos
Antes de iniciar, verifique se possui os seguintes componentes instalados em sua máquina:

- ☕ **Java 17** ou superior  
- 🧰 **IDE** para desenvolvimento Java (ex: IntelliJ IDEA, Eclipse ou VS Code)  
- 🐙 **Git** instalado e configurado  
- 🐬 **MySQL Workbench** instalados  
- 🌐 **Maven** (caso não esteja integrado à IDE)  

---

### ⚙️ Passos para Instalação

1. **Clone o repositório** em seu ambiente local:
   ```bash
   git clone https://github.com/GuilhermeGomesDosSantos/Controle_Estoque_API.git
   ```

## Instrução do banco de dados
### No Mysql já é necessário que a base de dados esteja criada, caso não esteja crie o banco de dados.
```
CREATE DATABASE my_project;
```

2. Pela **IDE** clique em **Run Application**
3. Após a inicialização, a API estará disponível em:
```
http://localhost:8080
```
---

## 🔐 Funcionalidades e Permissões da API

### 👑 Usuário ADMIN
- ✅ **Cadastrar** novos produtos  
- 🔄 **Atualizar** informações de produtos existentes  
- ❌ **Deletar** produtos do estoque (necessário informar o **ID** do produto)  
- 🔍 **Visualizar** produtos (por ID ou nome)

### 👤 Usuário USER
- 🔍 **Apenas visualizar** produtos (por ID ou nome)
---

## ⚙️ Funcionalidades Principais
- **Cadastro de produtos** com informações essenciais *(name, price, amount, etc.)*  
- **Atualização e exclusão de produtos existentes** (exclusão restrita a usuários com função **ADMIN**)  
- **Listagem geral de produtos com paginação por nome**  
- **Busca detalhada de produtos por ID específico**  
- **Deleção de produtos por ID**, disponível apenas para usuários com permissão **ADMIN**  
- Sistema de autenticação **OAuth 2.0** com **JWT (token)**  
- **Validação de permissões** com base na função do usuário  

---

## Endpoints utilizados
### 1. Cadastro de usuário:
**Método:** `GET`
```
http://localhost:8080/auth/register
```
### 2. Login de usuário:
**Método:** `POST`
```
http://localhost:8080/auth/login
```
### 3. Cadastro de produtos
**Método:** `POST`
```
http://localhost:8080/product/createProduct
```
### 4. Atualização de produtos
**Método:** `PUT`
```
http://localhost:8080/product/updateProduct
```
### 5. Listagem de Produto por ID
**Método:** `GET`
```
http://localhost:8080/product/{id}
```
### 6. Listagem de todos os Produtos
**Método:** `GET`
```
http://localhost:8080/product/listAll
```
### 7. Listagem de produtos por nome
**Método:** `GET`
```
http://localhost:8080/product/name/{name}
```
### 8. Deleção de Produto por ID
**Método:** `DELETE`
```
http://localhost:8080/product/deleteProduct/{id}
```

## Realizando as Requisições

Para testar a API, você pode utilizar ferramentas como **Postman** ou **Insomnia**, que permitem enviar requisições HTTP de forma visual e interativa.

## 📄 Licença
Este projeto está sob a licença MIT — veja o arquivo [LICENSE](LICENSE) para mais detalhes.
