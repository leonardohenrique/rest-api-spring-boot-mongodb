# rest-api-spring-boot-mongodb
Sample Spring application accessing data with MongoDB

### Running

To run the application, execute:

`mvn spring-boot:run`

Once started you can access the APIs:

`http://localhost:8080/heroes`


### Creating a new hero

```
POST http://localhost:8080/heroes
Accept: application/json
Content-Type: application/json

{
  "name" : "Superman",
  "powers" : [
    "Flight",
    "Superhuman Speed",
    "Superhuman strength"
  ],
  "enemies": [
    {
      "name" : "Lex Luthor"
    },
    {
      "name" : "Darkseid"
    }
  ]
}

RESPONSE: HTTP 201 (Created)
```

### Retrieving all heroes

```
GET http://localhost:8080/heroes?page=0&size=10

Response: HTTP 200
```
