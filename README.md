# player-register-graphql
A basketball player registration with graphql

- Spring Boot & Graphql Example Api With Java11
- Mysql & Jpa
- http://localhost:8080/graphiql for the testing the api

# Graphql Query & Mutations Examples

{findAllPlayers {
  id
  name
  surname
  position
}}

mutation {
  createPlayer(player:{name:"x",surname:"y",position:C}){
    name,
    surname,
    id
  }
}

mutation {
 deletePlayer(id:2)
}
