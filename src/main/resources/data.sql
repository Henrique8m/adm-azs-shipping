insert into Tb_Fretes(id, custoporkilo, custodofrete, notafiscal, observacao) values (1, 5, 0, 25642, 'Entregar Dona Maria');

insert into Tb_Pacote(id, quantidade, altura, largura, comprimento, pesofinal ) values (1, 2 ,3 , 1, 2, 0);
insert into Tb_Pacote(id, quantidade, peso, pesofinal ) values (2, 1, 2, 0);
insert into Tb_Pacote(id, quantidade, altura, largura, comprimento, peso, pesofinal ) values (3, 1, 3, 4, 2, 2, 0);


insert into Tb_Clientes(id, name, email, telefone, cpf) values (1,'Bob Gren','Bob@gmail.com', '98646 1654','1234567890');
insert into Tb_Clientes(id, name, email, telefone, cpf) values (2,'Maria Gren','maria@gmail.com.br', '98668 1464','1234567890');


insert into Tb_Endereços(id, cliente_id, rua, numero, bairro, cidade, estado, cep, pais, complemento) values (1, 1, 'Rua Sao Paulo', 43 , 'Centro','Divinopolis', 'Minas Gerais', 35501000, 'Brasil', 'O Cara que mora ali na esquina');
insert into Tb_Endereços(id, cliente_id, rua, numero, bairro, cidade, estado, cep, pais, complemento) values (2, 2, 'Rua  Paulo', 2543 , 'ro','Divilis', 'erais', 3551000, 'Bril', 'O Cara ');


UPDATE
  tb_fretes
SET
  destinatario_id = 1,
  remetente_id = 2;


