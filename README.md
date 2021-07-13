# Hello Servlet

Este é um exemplo de aplicação utilizando Servlet 5.0

## Requirimentos

- Java 11+
- Tomcat 10.0+
- Maven

## Instruções

1. Primeiramente deve-se alterar a propriedade **tomcat.webapps.path** no arquivo pom.xml para o caminho da sua pasta local webapps do Tomcat.

2. Depois, utilizar o Maven para compilar e instalar a aplicação. No plugin do Maven da IDE Intellij utilizar a fase "package" ou o comando a seguir:

```bash
mvn clean package
```

3. O passo 2 deve ser repetido sempre que houver alguma alteração no código da aplicação.

## Endereço da aplicação

O Servlet deve estar disponível na seguinte URL:

http://localhost:8080/gerenciador/hello

E a página index.html na URL:

http://localhost:8080/gerenciador/

## Como aplicar as alterações sem reiniciar o servidor Tomcat

Localize o arquivo **context.xml** dentro da pasta **conf** do Tomcat. E realize as seguintes alterações:

1. Na tag Context adicione o atributo reloadable como valor "true"

````xml
<Context reloadable="true">
````

2. Dentro da tag Context adicione a seguinte tag:

```xml
<WatchedResource>WEB-INF/**</WatchedResource>
```