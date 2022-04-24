# Desafio AZShip

##Sistema de gestão de fretes
url
```
http://localhost:8080/graphiql

```
Banco de dados

 - H2 (+ Carga Inicial - data.sql)

Auxílio

 - Lombok
 - DevTools
 - ModelMapper
 - GraphiQL

Ferramentas
- Spring Boot
- graphQL



# 1. Querys de Busca 
## - Buscar Frete
###Ao buscar um frete, devera inserir a Chave Estrangeira do mesmo!!
###Sua busca, poderá retornar as seguintes informaçoes:
- custoporkilo
- custodofrete
- notafiscal
- observacao
- destinatario
- remetente
- pacote
###Exemplo:
```
{
  frete(id:1){
    id
    custoporkilo
    custodofrete
    notafiscal
    observacao
    destinatario{
      name
      email
      telefone
      cpf
      cnpj
      endereco{
        rua        
      }      
    }
    remetente{
      name
      email
      telefone
      cpf
      cnpj
      endereco{
        rua        
      }  
    }
    pacote{
      id
      metadado
      fatordecubagem
      quantidade
      pesofinal
    }
  }
}
```
##exemplo de busca onde retornamos todos os fretes cadastrados:
```
{
  fretes{
    id
    custoporkilo
    custodofrete
    notafiscal
    observacao
    destinatario{
      name
      email
      telefone
      cpf
      cnpj
      endereco{
        rua        
      }      
    }
    remetente{
      name
      email
      telefone
      cpf
      cnpj
      endereco{
        rua        
      }  
    }
    pacote{
      id
      metadado
      fatordecubagem
      quantidade
      pesofinal
    }
  }
}
```
## - Buscar Cliente
###Ao buscar um cliente, devera inserir a Chave Estrangeira do mesmo!!
###Sua busca, poderá retornar as seguintes informaçoes:
- name
- email
- telefone
- cpf
- cnpj
- endereco
###Exemplo:
- Por id
```
{
  cliente(id:1){
    id
    name
    email
    telefone
    cpf
    cnpj
    endereco{
      id
      cep
      rua
      numero
      bairro
      estado
      pais
      complemento
    }
  }
}
```
- Todos
```
{
  clientes{
    id
    name
    email
    telefone
    cpf
    cnpj
    endereco{
      id
      cep
      rua
      numero
      bairro
      estado
      pais
      complemento
    }
  }
}
```
## - Buscar Pacote
###Ao buscar um pacote, devera inserir a Chave Estrangeira do mesmo!!
###Sua busca, poderá retornar as seguintes informaçoes:
- id
- metadado
- fatordecubagem
- quantidade
- pesofinal
###Exemplo:
- Por id
```
{
  pacote(id:1){
    id
    metadado
    fatordecubagem
    quantidade
    pesofinal
  }
}
```
- Todods
```
{
  pacotes{
    id
    metadado
    fatordecubagem
    quantidade
    pesofinal
  }
}
```
## - Buscar Endereço
###Ao buscar um endereço, devera inserir a Chave Estrangeira do mesmo!!
###Sua busca, poderá retornar as seguintes informaçoes:
- id
- cep
- rua
- numero
- bairro
- estado
- pais
- complemento
###Exemplo:
- Por id
```
{
  endereco(id:1){
    id
    cep
    rua
    numero
    bairro
    estado
    pais
    complemento
  }
}
```
- Todos
```
{
  enderecos{
    id
    cep
    rua
    numero
    bairro
    estado
    pais
    complemento
  }
}
```

# 2. Mutation para Cadastro 
## - Cadastrar Frete
## Campos Obrigatorios:
- custoporkilo
- notafiscal
- destinatario
- remetente
- pacote
### Campo adcional
- observacao
### Tendo em vista que Remetente, Destinatario, Pacote, serão associados por meio de sua Chave Estrangeira
###Exemplo:

```
mutation{
 mutation{
 saveFrete(frete:{
    custoporkilo:15
    notafiscal:45434
    observacao:"Remeça para Teste de Cadastro"
    destinatario:2
    remetente:1
    pacote:[1,3]
    })
  
  {
      id
      custoporkilo
      custodofrete
      notafiscal
      observacao
      destinatario{
        id
        name
        email
        telefone
        cpf
        cnpj
        endereco{
          id
          cep
          rua
          numero
          bairro
          estado
          pais
          complemento
        }
      }
      remetente{
        id
        name
        email
        telefone
        cpf
        cnpj
        endereco{
          id
          cep
          rua
          numero
          bairro
          estado
          pais
          complemento
        }
  		}
    pacote{
      id
      metadado
      fatordecubagem
      quantidade
      pesofinal
    }
  }
}
```
## - Cadastrar Cliente
## Campos Obrigatorios:
- name
- telefone
- cpf
### Campos adcionais
- cnpj
- email
- enderecos
### Tendo em vista que endereço, sera associados por meio da sua Chave Estrangeira
###Exemplo:

```
mutation{
  saveCliente(cliente:{
    name:"Carolina Lorena"
    email:"Carol@gmail.com"
    telefone:"37 996523 6462"
    cpf: "1234567890"
    enderecos:[1]
  }){
    id
    name
    telefone
    cpf
    endereco{
      id
      cep
      rua
      numero
      bairro
      estado
      pais
      complemento
    }
  }
}
```
## - Cadastrar Pacote
## Campos Obrigatorios:
- quantidade
### Campos adcionais
- fatordecubagem
- altura
- largura
- comprimento
- peso
###Exemplo:

```
mutation{
savePacote(pacote:{
fatordecubagem:24
quantidade:1
altura:10
largura:5
comprimento:3
peso:1
}){
id
metadado
fatordecubagem
quantidade
pesofinal
}
}
```
## - Cadastrar Endereço
## Campos Obrigatorios:
- cep
- rua
- numero
- bairro
- estado
- pais
### Campos adcionais
- complemento
###Exemplo:

```
mutation{
  saveEndereco(endereco:{
    cep:35501106
    rua:"Atravessa Dom Pedro Primeiro"
  	numero:50
    bairro:"Vila Cruseiro"
    estado:"Minas Gerais"
    pais:"Brasil"
    complemento:"Rua sem saída"
  }){
    id
    cep
    rua
    numero
    bairro
    estado
    pais
    complemento
  }
}
```

# 3. Mutation para Atualizar
## Atualizar Frete
## Campos Obrigatorios:
- id
- pacote
### Campo adcional
- observacao
- custoporkilo
- notafiscal
- destinatario
- remetente

##Exemplo:
- os campos que estiverem nulos, permaneceram os mesmos
```

mutation{
 updatedFrete(frete:{
    id:2
    custoporkilo:15
    notafiscal:8956
    observacao:"Remeça"
    destinatario:2
    remetente:1
    pacote:[1,3]
    }){
      id
      custoporkilo
      custodofrete
      notafiscal
      observacao
      destinatario{
        id
        name
      }
      remetente{
        id
        name
      }
      pacote{
        id
        pesofinal
      }
  }
}

```
## Atualizar Cliente
## Campos Obrigatorios:
- id
### Campo adcional
- name
- email
- telefone
- cpf
- cnpj

###Exemplo:
```

mutation{
  updatedCliente(cliente:{
    id:3
    name:"Carolina Lorena"
    email:"Carol@gmail.com"
    telefone:"37 996523 6462"
    cpf: "1234567890"
    enderecos:[1]
  }){
    id
    name
    telefone
    cpf
    endereco{
      id
      cep
      rua
      numero
      bairro
      estado
      pais
      complemento
    }
  }
}

```
## Atualizar Pacote
## Campos Obrigatorios:
- id
- quantidade
### Campo adcional
- fatordecubagem
- altura
- largura
- comprimento
- peso

###Exemplo:
```

mutation{
 updatedPacote(pacote:{
    id:10
    fatordecubagem:24
    quantidade:1
    altura:5
    largura:5
    comprimento:3
    peso:1
  }){
    id
    metadado
    fatordecubagem
    quantidade
    pesofinal
  }
}

```
## Atualizar Endereço
## Campos Obrigatorios:
- id
### Campo adcional
- cep
- rua
- numero
- bairro
- estado
- pais
- complemento

###Exemplo:
```

mutation{
  updatedEndereco(endereco:{
    id:3
    cep:26500185
    rua:"Atravessa Dom Pedro Segundo"
    numero:5058
    bairro:"Vila Vicentina"
    estado:"São Paulo"
    pais:"Brasil"
    complemento:"Rua do comercio"
  }){
    id
    cep
    rua
    numero
    bairro
    estado
    pais
    complemento
  }
}

```

# 4. Mutation para Remover
## - Remover Frete
###Exemplo:
###Frete
```

mutation{
  removerFrete(id:1)
}

```
###Cliente
- para deletar o cliente, tem que deletar antes o frete a ele acossiado
```

mutation{
removerCliente(id:1)
}

```
###Pacote
```

mutation{
  removerPacote(id:1)
}

```
###Endereço
```

mutation{
removerEndereco(id:1)
}

```

