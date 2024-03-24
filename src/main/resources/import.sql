/*
-- Administrador
insert into administrador ( id, nome, login, senha, cpf, matricula, perfil) 
values( 1, 'Victor Alves', 'victor@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '753.369.654-98', 159, 2);
insert into administrador ( id, nome, login, senha, cpf, matricula, perfil) 
values( 2, 'Aline barros', 'alineb@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '023.396.147-08', 111, 2);
insert into administrador ( id, nome, login, senha, cpf, matricula, perfil) 
values( 3, 'Gloria Groover', 'gg@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '063.369.688-05', 257, 2);

-- Telefones
insert into telefone ( codArea, numero) values( '63', '98478-3692');
insert into telefone ( codArea, numero) values( '62', '99999-9688');
insert into telefone ( codArea, numero) values( '63', '99928-9652');
insert into telefone ( codArea, numero) values( '63', '98147-9522');
insert into telefone ( codArea, numero) values( '62', '94856-9959');
insert into telefone ( codArea, numero) values( '61', '98477-9772');
insert into telefone ( codArea, numero) values( '99', '99978-9699');

-- Estados
insert into estado ( nome, sigla) values( 'Tocantins', 'TO');
insert into estado ( nome, sigla) values( 'Maranhão', 'MA');
insert into estado ( nome, sigla) values( 'Pará', 'PA');
insert into estado ( nome, sigla) values( 'Goiás', 'GO');

-- Cidades
insert into cidade ( nome, id_estado) values( 'Palmas', 1);
insert into cidade ( nome, id_estado) values( 'Carolina', 2);
insert into cidade ( nome, id_estado) values( 'Belém', 3);
insert into cidade ( nome, id_estado) values( 'Goiania', 4);

-- Endereços
insert into endereco ( logradouro, numero, complemento, bairro, cep, cidade_id)
values( 'Alameda 18', '88', 'Próximo ao mercado', '108 Norte', '74985-888', 1); 
insert into endereco ( logradouro, numero, complemento, bairro, cep, cidade_id)
values( 'Alameda 4', '12', 'Próximo a praça', '106 Sul', '74985-333', 2);
insert into endereco ( logradouro, numero, complemento, bairro, cep, cidade_id)
values( 'Alameda 10', '58', 'Próximo ao mercado', '604 Norte', '70084-885', 3);
insert into endereco ( logradouro, numero, complemento, bairro, cep, cidade_id)
values( 'Alameda 12', '85', 'Próximo a escola', '303 Norte', '72585-858', 4);
insert into endereco ( logradouro, numero, complemento, bairro, cep, cidade_id)
values( 'Alameda 7', '42', 'Portão Azul', '406 Norte', '74585-558', 4);
insert into endereco ( logradouro, numero, complemento, bairro, cep, cidade_id)
values( 'Alameda 8', '38', 'Murro verde e Portão preto', '504 Norte', '74854-666', 3);
insert into endereco ( logradouro, numero, complemento, bairro, cep, cidade_id)
values( 'Alameda 3', '37', 'Próximo ao mercado BIG', '502 Norte', '74885-698', 2);

-- Clientes
insert into cliente ( nome, login, senha, cpf, dataNascimento, perfil) 
values( 'Victor Alves', 'alves@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '753.001.654-98', '2000-05-04', 1);
insert into cliente ( nome, login, senha, cpf, dataNascimento, perfil) 
values( 'Bruno barros', 'bbruno@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '023.396.158-08', '1995-03-01', 1);
insert into cliente ( nome, login, senha, cpf, dataNascimento, perfil) 
values( 'Dany Bananinha', 'bananas@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '522.369.528-05', '1997-01-04', 1);
insert into cliente ( nome, login, senha, cpf, dataNascimento, perfil) 
values( 'Eliana do SBT', 'eliana@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '001.311.102-15', '1998-02-02', 1);
insert into cliente ( nome, login, senha, cpf, dataNascimento, perfil) 
values( 'Ana Vitoria', 'vitoriadaana@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '099.389.963-11', '1998-06-06', 1);
insert into cliente ( nome, login, senha, cpf, dataNascimento, perfil) 
values( 'Ana ', 'vitoriadaana@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '099.389.963-11', '1998-06-06', 1);
insert into cliente ( nome, login, senha, cpf, dataNascimento, perfil) 
values( 'Vitoria', 'vitoriadaana@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '099.389.963-11', '1998-06-06', 1);


-- Clientes -> telefones
insert into cliente_telefone (id_cliente, id_telefone) values( 1);
insert into cliente_telefone (id_cliente, id_telefone) values( 2);
insert into cliente_telefone (id_cliente, id_telefone) values( 3);
insert into cliente_telefone (id_cliente, id_telefone) values( 4);
insert into cliente_telefone (id_cliente, id_telefone) values( 5);
insert into cliente_telefone (id_cliente, id_telefone) values( 6);
insert into cliente_telefone (id_cliente, id_telefone) values( 7);

-- Clientes -> endereços
insert into cliente_endereco (id_cliente, id_endereco) values( 1);
insert into cliente_endereco (id_cliente, id_endereco) values( 2);
insert into cliente_endereco (id_cliente, id_endereco) values( 3);
insert into cliente_endereco (id_cliente, id_endereco) values( 4);
insert into cliente_endereco (id_cliente, id_endereco) values( 5);
insert into cliente_endereco (id_cliente, id_endereco) values( 6);
insert into cliente_endereco (id_cliente, id_endereco) values( 7);

-- Pix
insert into pix ( chavePix) values( 'carlos@gmail.com');
insert into pix ( chavePix) values( '9998563254');

-- Boleto Bancario
insert into boletoBancario ( banco, numeroBoleto, dataVencimento) 
values( 'Bradesco', '36985214789', '2026-05-03');
insert into boletoBancario ( banco, numeroBoleto, dataVencimento) 
values( 'Next', '036985523', '2028-05-04');
insert into boletoBancario ( banco, numeroBoleto, dataVencimento) 
values( 'Nubank', '951555887', '2024-02-05');

-- Cartão de Crédito
insert into cartaoCredito ( bandeira, numeroCartao, codigoSeguranca, dataVencimento) 
values( 'Visa', '111225589', '123', '2024-03-08');
insert into cartaoCredito ( bandeira, numeroCartao, codigoSeguranca, dataVencimento) 
values( 'Alguma', '111225589', '444', '2024-03-08');
insert into cartaoCredito ( bandeira, numeroCartao, codigoSeguranca, dataVencimento) 
values( 'Visa', '111225589', '569', '2024-03-08');

-- Modelos

insert into modelo ( nome, marca) values( 'Iphone Xr', 'Apple');
insert into modelo ( nome, marca) values( 'A45', 'Samsung');
insert into modelo ( nome, marca) values( 'Iphone X', 'Apple');
insert into modelo ( nome, marca) values( 'A50', 'Samsung');

-- Capinhas

insert into capinha ( nome, descricao, valor, quantEstoque, modelo_id, cor)
values( 'Capinha de Glitter', 'Uma capinha de celular', 25.0, 30, 1, 'AZUL');
insert into capinha ( nome, descricao, valor, quantEstoque, modelo_id, cor)
values( 'Capinha de titânio ', 'Uma capinha de celular', 45.0, 5, 2, 'VERDE');
insert into capinha ( nome, descricao, valor, quantEstoque, modelo_id, cor)
values( 'Capinha de Madeira ', 'Uma capinha de celular', 45.0, 5, 3, 'VERMELHO');
insert into capinha ( nome, descricao, valor, quantEstoque, modelo_id, cor)
values( 'Capinha de titânio ', 'Uma capinha de celular', 45.0, 5, 4, 'TRANSPARENTE');
insert into capinha ( nome, descricao, valor, quantEstoque, modelo_id, cor)
values( 'Capinha de Glitter ', 'Uma capinha de celular', 45.0, 5, 1, 'LARANJA');
*/

insert into marca ( nome) values('Samsung');
insert into marca ( nome) values('Xiaomi');
insert into marca ( nome) values('LG');
