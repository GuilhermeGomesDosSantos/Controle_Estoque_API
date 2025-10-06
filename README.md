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
#### Body
> 💡 **Informação Importante:**  
> O campo **`role`** deve obrigatoriamente ser `"USER"` ou `"ADMIN"`.  
>
> - Usuários com função **`USER`** podem **apenas visualizar produtos**.  
> - Usuários com função **`ADMIN`** podem **criar, atualizar, visualizar e deletar produtos**.
```
{
    "login":"guilherme.santos11",
    "password":"123456",
    "role":"USER"
}
```
#### Response
```
{
    "id": 3,
    "login": "guilherme.santos11",
    "role": "USER"
}
```

### 2. Login de usuário:
**Método:** `POST`
```
http://localhost:8080/auth/login
```
#### Body
```
{
    "login":"guilherme.santos11",
    "password":"123456"
}
```
#### Response
>💡 **Informação Importante:**  
> O **`token`** gerado deve obrigatoriamente utilizado para as demais requisições.  
>
> - Usuários com função **`USER`** podem **apenas visualizar produtos**.
> - Usuários com função **`ADMIN`** podem **criar, atualizar, visualizar e deletar produtos**.
```
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6Imd1aWxoZXJtZS5zYW50b3MxMSIsImV4cCI6MTc1OTcxMTgwM30.7ITN8lL6SxH3d6IPDmPcoMjteaMMM9WuoiZiNA8O09A"
}
```

### 3. Cadastrar produtos
**Método:** `POST`
```
http://localhost:8080/product/createProduct
```
#### Body
```
{
  "name": "Refrigerante Coca-Cola",
  "amount": 45,
  "price": 9.50,
  "category": "BEBIDAS",
  "brand": "Coca-Cola",
  "weight": {
    "value": 2.0,
    "unit": "L"
  }
}
```
#### Response
```
{
    "id": 11,
    "name": "Refrigerante Coca-Cola",
    "amount": 45,
    "price": 9.5,
    "category": "BEBIDAS",
    "brand": "Coca-Cola",
    "weight": {
        "unit": "L",
        "value": 2.0
    },
    "createdAt": "2025-10-05",
    "lastUpdate": "2025-10-05"
}
```
### 4. Atualização de produtos
**Método:** `PUT`
```
http://localhost:8080/product/updateProduct
```
#### Body
```
{
  "id":11,
  "weight": {
    "value_": 3.0
  }
}
```
#### Response
```
{
    "id": 11,
    "name": "Refrigerante Coca-Cola",
    "amount": 45,
    "price": 9.5,
    "category": "BEBIDAS",
    "brand": "Coca-Cola",
    "weight": {
        "unit": "L",
        "value": 3.0
    },
    "createdAt": "2025-10-05",
    "lastUpdate": "2025-10-05"
}
```
### 5. Listagem de Produto por ID
**Método:** `GET`
```
http://localhost:8080/product/{id}
```
#### URL request
```
http://localhost:8080/product/11
```
#### Response
```
{
    "id": 11,
    "name": "Refrigerante Coca-Cola",
    "amount": 45,
    "price": 9.5,
    "category": "BEBIDAS",
    "brand": "Coca-Cola",
    "weight": {
        "unit": "L",
        "value": 3.0
    },
    "createdAt": "2025-10-05",
    "lastUpdate": "2025-10-05"
}
```
### 6. Listagem de todos os Produtos
**Método:** `GET`
```
http://localhost:8080/product/listAll
```
#### Response
```
[
    {
        "id": 10,
        "name": "Arroz Branco teste",
        "amount": 31,
        "price": 21.2,
        "category": "MERCEARIA",
        "brand": "Tio João",
        "weight": {
            "unit": "KG",
            "value": 15.5
        },
        "createdAt": "2025-10-05",
        "lastUpdate": "2025-10-05"
    },
    {
        "id": 11,
        "name": "Refrigerante Coca-Cola",
        "amount": 45,
        "price": 9.5,
        "category": "BEBIDAS",
        "brand": "Coca-Cola",
        "weight": {
            "unit": "L",
            "value": 3.0
        },
        "createdAt": "2025-10-05",
        "lastUpdate": "2025-10-05"
    }
]
```
### 7. Listagem de produtos por nome
**Método:** `GET`
```
http://localhost:8080/product/name/{name}
```
#### URL request
```
http://localhost:8080/product/name/refrigerante
```
#### Response
```
{
    "content": [
        {
            "id": 11,
            "name": "Refrigerante Coca-Cola",
            "amount": 45,
            "price": 9.5,
            "category": "BEBIDAS",
            "brand": "Coca-Cola",
            "weight": {
                "unit": "L",
                "value": 3.0
            },
            "createdAt": "2025-10-05",
            "lastUpdate": "2025-10-05"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 5,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 1,
    "size": 5,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}
```
### 8. Deleção de Produto por ID
**Método:** `DELETE`
```
http://localhost:8080/product/deleteProduct/{id}
```
#### URL request
```
http://localhost:8080/product/deleteProduct/11
```

## Realizando as Requisições

Para testar a API, você pode utilizar ferramentas como **Postman** ou **Insomnia**, que permitem enviar requisições HTTP de forma visual e interativa.
### 1. Cadastro de usuário:
#### Request
<img width="1385" height="559" alt="image" src="https://github.com/user-attachments/assets/22332d91-0a14-4446-b7bd-13e716716aaa" />

#### Response
<img width="919" height="315" alt="image" src="https://github.com/user-attachments/assets/a70c4fb3-45dc-4fdd-8be1-c8a36847f434" />

### 2. Login
#### Request
<img width="798" height="295" alt="image" src="https://github.com/user-attachments/assets/117c9111-a9ac-4fc0-be5b-819c20e438e0" />

#### Response
<img width="1375" height="526" alt="image" src="https://github.com/user-attachments/assets/45fc6055-8ecc-491d-a7c4-c7ab6d0d7f27" />

### 3. Cadastrar Produtos
#### Body
<img width="784" height="457" alt="Captura de tela 2025-10-05 200507" src="https://github.com/user-attachments/assets/d1072f5b-afbf-4da3-a9a6-363f57cdee05" />

#### Response
<img width="1380" height="832" alt="Captura de tela 2025-10-05 201513" src="https://github.com/user-attachments/assets/5bba7085-e857-4780-b824-8f372a7f8b87" />

### 4. Atualizar Produto
#### Request
<img width="777" height="345" alt="Captura de tela 2025-10-05 201813" src="https://github.com/user-attachments/assets/2aa40fd5-9a89-4619-9a78-2ef6d9fa5938" />

#### Response
<img width="1366" height="817" alt="Captura de tela 2025-10-05 201828" src="https://github.com/user-attachments/assets/8a5ff99d-49bb-4e51-b5a9-21eb69d5245e" />

### 5. Listagem de Produto por ID
#### Response
<img width="1375" height="766" alt="Captura de tela 2025-10-05 202132" src="https://github.com/user-attachments/assets/de66f431-8400-4b21-8791-56bdec508f27" />

### 6. Listagem de todos os Produtos
#### Response
<img width="1377" height="834" alt="Captura de tela 2025-10-05 202253" src="https://github.com/user-attachments/assets/c896ca1c-53d3-4db8-af59-8301395b4936" />

### 7. Listagem de produtos por nome
#### Response
<img width="1369" height="822" alt="Captura de tela 2025-10-05 202537" src="https://github.com/user-attachments/assets/0c1f0a8a-6ef5-4866-83c3-54c7d0222a3c" />

### 8. Deleção de Produto por ID
#### Request
<img width="1380" height="400" alt="Captura de tela 2025-10-05 203108" src="https://github.com/user-attachments/assets/a2c921ec-80f8-407e-9d1a-2974d1b0a71b" />

## 📄 Licença
Este projeto está sob a licença MIT — veja o arquivo [LICENSE](LICENSE) para mais detalhes.
