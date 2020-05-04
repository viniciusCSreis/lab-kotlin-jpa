Esse repo foi feito para testar o comportamento do jpa e o kotlin.

#Para subir a aplicação é utilizado Java 8 e Mvn

você não precisar ter java8 nen maven na sua maquina já que foi criado um docker para aplicação, para subir apenas utiliza o comando
```
docker-compose up --build --force-recreate
```

foi criado o endpoint /search
```
curl localhost:8080/search
```
esse endpoint faz um findAll , logo como está lazy não deveria retornar os post

foi criado o endpoint /join
```
curl localhost:8080/join
```
esse endpoint faz um findAll mas pegas os Ids de post, mas como esse valor ainda está na tabela de comments não deveria fazer uma nova request, para isso foi adicionado a annotation  @Access(AccessType.PROPERTY)

foi criado o endpoint /eager
```
curl localhost:8080/eager
```
esse endpoint faz um findAll mas acessa o title dos post logo vc deve ver 2 request a tabela post alem do findAll
