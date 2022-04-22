# Desafio AZShip

Sistema de gestão de fretes

# 1. Query
- Buscar Frete
```
{
  frete(id:1) {
    id
    custo
    nota
    nome
    cliente
    destinatario
    produtos
  }
}
```
- Buscar todos Fretes
```
{
  fretes{
    id
    custo
    nota
    nome
    cliente
    destinatario
    produtos
  }
}
```
# 2. Mutation
- Cadastrar Frete
```
mutation {
  save(frete:{
        custo: "2560 RS",
        nota: "35642-01",
        nome: "Remeça para pedro paulo",
        cliente: "null",
        destinatario: "Paulo",
        produtos: "null"
  }){
    id
    custo
    nota
    nome
    cliente
    destinatario
    produtos
  }
}
```
- Atualizar dados do Frete
```
mutation {
  updated(frete:{
    		id:"1"
        custo: "2560 RS",
        nota: "35642-012",
        nome: "Remeça para pedro paulo",
        cliente: "null",
        destinatario: "Paulo",
        produtos: "null"
  }){
    id
    custo
    nota
    nome
    cliente
    destinatario
    produtos
  }
}
```
- Remover Frete
```
mutation {
  removerFrete(id:1)
}
```