# Projeto de Backend Avançado com Java

### Pré-requisitos

* [Java 8](http://www.matera.com/blog/post/tutorial-instalacao-do-java-jdk-e-eclipse-no-windows)
* [Maven](http://www.matera.com/blog/post/tutorial-instalacao-apache-maven-configuracao-eclipse)

## Construído com

 * [Java](https://www.oracle.com/technetwork/pt/java/javase/overview/index.html) - O framework web usado
 * [Spring](https://spring.io/) - Utilizado para boot , transações, api, resources e etc.
 * [Hibernate](http://hibernate.org/) - Usado para gerar as tabelas e realizar a persistência dos dados 
 * [hsqldb](http://hsqldb.org/) - Usado para armazenamento das informações

## Instalando

O aplicativo usa o Spring Boot, por isso é fácil de executar. 
> Você pode inicializar de algumas maneiras:
    
 1. Descompactar o projeto em uma pasta de sua preferência
    * `D:\backend>`
    
 1. Acesse a pasta via dos e execute o comando
    * `D:\backend\backend-avancado-java-master>mvn package`

 1. Inicialize o projeto 
    * `D:\backend\backend-avancado-java-master\target>java -jar bea-0.0.1-SNAPSHOT.jar`

## Visualizando o aplicativo

Para visualizar o aplicativo em execução, visite [http://localhost:8080/contatos](http://localhost:8080/contatos) em seu navegador

 * Listar todos os contatos (GET)
 
    http://localhost:8080/contatos

 * Para listar todos os contatos que pertencem a um cpf (GET)
 
    http://localhost:8080/contatos/search/findContatoByCpf?cpf=69083026019

 * Para consultar um contato (GET)
 
    http://localhost:8080/contatos/2

 * Para incluir um contato (POST)

    http://localhost:8080/contatos


```json 
{
    "cpf": "99988877766",
    "descricao": "(62) 9999-8877",
    "tipo": "CELULAR"
}
```

## Autores

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore -->
| [<img src="https://avatars3.githubusercontent.com/u/1007389?s=400&v=4" width="100px;"/><br /><sub><b>Renato Araujo</b></sub>](https://github.com/orenatoaraujo)<br /> | [<img src="https://avatars2.githubusercontent.com/u/8239569?s=460&v=4" width="100px;"/><br /><sub><b>danylo-macelai</b></sub>](https://github.com/danylo-macelai)<br />  | [<img src="https://avatars0.githubusercontent.com/u/6737144?s=460&v=4" width="100px;"/><br /><sub><b>brenicio</b></sub>](https://github.com/brenicio)<br /> |
| :-------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------------------------------------------: |
<!-- ALL-CONTRIBUTORS-LIST:END -->
