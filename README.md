# Help Desk
Este exercício prático visa acompanhar atendimentos até que a resolução de um problema seja atingida.

# Tecnologias
O tutorial está na versão 1.5 do spring e java 8. Mas eu estou usando a versão 3.1.3 do spring e java 17.

## Erros, soluções e ajustes

É esperado que haja muitos ajustes técnicos para que a aplicação funcione como esperado porque estou usando versões bem mais novas das bibliotecas.

### spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.ImprovedNamingStrategy deprecated

Em princípio, apenas removi, deixando a estratégia padrão de mapeamento objeto-relacional.

### Aplicação inicia e para imediatamente

Faltou o spring-boot-starter-web no arquivo build.gradle

	implementation 'org.springframework.boot:spring-boot-starter-web'

### A coisa não funciona
Não encontra as anotações de validação porque não incluiu o bean validator.

    implementation 'org.springframework.boot:spring-boot-starter-validation'

Dá erro no lombok quando uso a anotação @RequiredArgsContructor. Tem que adicionar o plugin do lombok no gradle.build

    plugins {
        id 'java'
        id 'org.springframework.boot' version '3.1.3'
        id 'io.spring.dependency-management' version '1.1.3'
        id("io.freefair.lombok") version "8.3"
    }

Não substitui o método POST pelo método DELETE. Precisa configurar pra fazer isso no application.properties.

    ## MVC
    spring.mvc.hiddenmethod.filter.enabled=true

### Já sei que não vai funcionar o layout do thymeleaf
Porque não incluiu a dependência.

	// https://mvnrepository.com/artifact/nz.net.ultraq.thymeleaf/thymeleaf-layout-dialect
	implementation group: 'nz.net.ultraq.thymeleaf', name: 'thymeleaf-layout-dialect', version: '3.2.1'

### Visualização

Para visualizar o desenvolvimento gradual, ainda não pode incluir a segurança.

	//implementation 'org.springframework.boot:spring-boot-starter-security'
Em templates/users/index.html

    <html lang="pt_BR"
      xmlns:th="http://thymeleaf.org"
      xmlns:layout="http://ultraq.net.nz/thymeleaf/layout"
    layout:decorate="layout">

No bootstrap, ao invés da classe CSS navbar-toggleable-md, deve ser usada navbar-expand-md.

    <nav class="navbar navbar-expand-md navbar-inverse bg-primary">

