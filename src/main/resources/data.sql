insert into Tb_Fretes(id, custo, nota, nome) values (1, '2560 RS','35642-01', 'Remeça para pedro paulo');

insert into Tb_Motoristas(id, name, email, telefone, cpf) values (1, 'Pedro Gren','Pedro@gmail.com', '986461464','1234567890');

insert into Tb_Produtos(id, quantidade, cubagem, formato, peso) values (1, '2','3 m³', 'Padrão','30 Kg');

insert into Tb_Endereços(id, rua, numero, bairro, cidade, estado, cep, pais, complemento) values (1, 'Rua Sao Paulo',' 43 ', 'Centro','Divinopolis', 'Minas Gerais', '35501-000', 'Brasil', 'O Cara que mora ali na esquina');
insert into Tb_Endereços(id, rua, numero, bairro, cidade, estado, cep, pais, complemento) values (2, 'Rua  Paulo',' 43 ', 'ro','Divilis', 'erais', '3551-000', 'Bril', 'O Cara ');

insert into Tb_Clientes(id, name, email, telefone, cpf) values (1,'Bob Gren','Bob@gmail.com', '986461464','1234567890');

UPDATE
  `Tb_Endereços`
SET
  cliente_id = 1;

UPDATE
  Tb_Fretes
SET
  destinatario_id = 1;

UPDATE
  Tb_Produtos
SET
  frete_id = 1;