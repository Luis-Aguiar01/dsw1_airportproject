# ✈ Airport System

> Sistema web desenvolvido para o gerenciamento de voos.

---

## 📜 Sobre o Projeto
O **Airport System** é um sistema de gerenciamento de voos desenvolvido com foco em organização e boas práticas de design de software. 
Ele oferece funcionalidades específicas para dois tipos de usuários:

- **Administradores:** Podem cadastrar, atualizar e visualizar os estados dos voos.  
- **Clientes:** Têm acesso aos totens de informações de voos, onde podem visualizar detalhes importantes dos voos disponíveis no sistema.  

## Arquitetura e Design de Software
- **Padrão State**: Utilizado para gerenciar os estados dos voos, que podem ser: Arriving, Boarding, TakingOff e TookOff.
- **Padrão Front Controller**: Todas as requisições são centralizadas em um único Servlet, simplificando o fluxo de controle.
- **Padrão Command**: Implementado para separar a lógica de processamento de cada requisição no Servlet principal, promovendo modularidade.
- **Padrão MVC**: Adotado para garantir a separação clara entre as camadas de Model, View e Controller.

## Objetivo
Este sistema tem como propósito simplificar a administração e consulta de voos, proporcionando uma interface intuitiva e eficiente. Além disso, o projeto foi desenvolvido como parte da disciplina Desenvolvimento de Software para Web I do IFSP Araraquara.

---

## 🚀 Tecnologias Utilizadas

- **Back-end:** Java 17, JSP, Servlet  
- **Front-end:** HTML, CSS, TailwindCSS  
- **Servidor** Apache Tomcat 10.1
- **IDE** Eclipse EE 2023-09
  
---

## 📸 Screenshots

### Página Inicial  
Apresenta as principais funcionalidades e acesso ao sistema.  
![Página Inicial](screenshots/index.png)

### Login do Administrador  
Interface de autenticação para administradores.  
![Login do Administrador](screenshots/login.png)

### Tabela de Voos e Cadastro (Administrador)  
Visão geral dos voos cadastrados e formulário para incluir novos voos.  
![Tabela de Voos](screenshots/general-flights.png)

### Cadastro de Voo (Administrador)  
Formulário utilizado para registrar novos voos.  
![Cadastro de Voo](screenshots/flight-register.png)

### Voo Cadastrado  
Visualização de um voo registrado no sistema.  
![Voo Cadastrado](screenshots/general-flight2.png)

### Totem do voo em estado chegando  
Visualização de um voo registrado no sistema.  
![Totem Chegando](screenshots/totem-arriving.png)

---

## 👤 Autor

**Nome:** Luis Henrique Aguiar  
**E-mail:** luis.aguiar@aluno.ifsp.edu.br  

---
