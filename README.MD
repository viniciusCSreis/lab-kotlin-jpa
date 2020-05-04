para rodar a aplicação:
```
docker-compose up --build --force-recreate
```

ao bater o endpoint /search

```
curl localhost:8080/search
```

vc vai ver o log:
```
webapp_1  | Hibernate: select postcommen0_.id as id1_1_, postcommen0_.post_id as post_id3_1_, postcommen0_.review as review2_1_ from post_comment postcommen0_
webapp_1  | Hibernate: select post0_.id as id1_0_0_, post0_.title as title2_0_0_ from post post0_ where post0_.id=?
webapp_1  | Hibernate: select post0_.id as id1_0_0_, post0_.title as title2_0_0_ from post post0_ where post0_.id=?
```
como podem ver um findAll está pegando os post mesmo com lazy


ao descomentar o pom (você pode olhar o pom da master para ver onde colocar esse pluginOptions)
```
<pluginOptions>
    <option>spring:annotation=javax.persistence.Entity</option>
</pluginOptions>
```

e reiniciar o servidor os logs ficam:

```
webapp_1  | Hibernate: select postcommen0_.id as id1_1_, postcommen0_.post_id as post_id3_1_, postcommen0_.review as review2_1_ from post_comment postcommen0_
```