
# 1 - Cliente
##Por id
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

## Todos
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
### Cadastrar

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
### Atualizar

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


# 2 - Frete
## Por Id
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
##Todos
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
## Cadastrar

```
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
## Atualizar

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
# 3 - Pacotes

##Por id

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
##Todos
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
##Cadastrar
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
##Atualizar
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

# 4 - Endereço

##Por id
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
## Todos

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
##Cadastrar

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
##Atualizar

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
# 5 - Remover
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