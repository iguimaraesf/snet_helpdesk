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

### Não encontra as anotações de validação
Porque não incluiu o bean validator.

    implementation 'org.springframework.boot:spring-boot-starter-validation'
