
-- Administrador
insert into administrador (id, nome, login, senha, cpf, matricula, perfil) 
values(1, 'Victor Alves', 'victor@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '753.369.654-98', 159, 2);
insert into administrador (id, nome, login, senha, cpf, matricula, perfil) 
values(2, 'Aline barros', 'alineb@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '023.396.147-08', 111, 2);
insert into administrador (id, nome, login, senha, cpf, matricula, perfil) 
values(3, 'Gloria Groover', 'gg@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '063.369.688-05', 257, 2);

-- Telefones
insert into telefone (id, codArea, numero) values(1, '63', '98478-3692');
insert into telefone (id, codArea, numero) values(2, '62', '99999-9688');
insert into telefone (id, codArea, numero) values(3, '63', '99928-9652');
insert into telefone (id, codArea, numero) values(4, '63', '98147-9522');
insert into telefone (id, codArea, numero) values(5, '62', '94856-9959');
insert into telefone (id, codArea, numero) values(6, '61', '98477-9772');
insert into telefone (id, codArea, numero) values(7, '99', '99978-9699');

-- Estados
insert into estado (id, nome, sigla) values(1, 'Tocantins', 'TO');
insert into estado (id, nome, sigla) values(2, 'Maranhão', 'MA');
insert into estado (id, nome, sigla) values(3, 'Pará', 'PA');
insert into estado (id, nome, sigla) values(4, 'Goiás', 'GO');

-- Cidades
insert into cidade (id, nome, id_estado) values(1, 'Palmas', 1);
insert into cidade (id, nome, id_estado) values(2, 'Carolina', 2);
insert into cidade (id, nome, id_estado) values(3, 'Belém', 3);
insert into cidade (id, nome, id_estado) values(4, 'Goiania', 4);

-- Endereços
insert into endereco (id, logradouro, numero, complemento, bairro, cep, cidade_id)
values(1, 'Alameda 18', '88', 'Próximo ao mercado', '108 Norte', '74985-888', 1); 
insert into endereco (id, logradouro, numero, complemento, bairro, cep, cidade_id)
values(2, 'Alameda 4', '12', 'Próximo a praça', '106 Sul', '74985-333', 2);
insert into endereco (id, logradouro, numero, complemento, bairro, cep, cidade_id)
values(3, 'Alameda 10', '58', 'Próximo ao mercado', '604 Norte', '70084-885', 3);
insert into endereco (id, logradouro, numero, complemento, bairro, cep, cidade_id)
values(4, 'Alameda 12', '85', 'Próximo a escola', '303 Norte', '72585-858', 4);
insert into endereco (id, logradouro, numero, complemento, bairro, cep, cidade_id)
values(5, 'Alameda 7', '42', 'Portão Azul', '406 Norte', '74585-558', 4);
insert into endereco (id, logradouro, numero, complemento, bairro, cep, cidade_id)
values(6, 'Alameda 8', '38', 'Murro verde e Portão preto', '504 Norte', '74854-666', 3);
insert into endereco (id, logradouro, numero, complemento, bairro, cep, cidade_id)
values(7, 'Alameda 3', '37', 'Próximo ao mercado BIG', '502 Norte', '74885-698', 2);

-- Clientes
insert into cliente (id, nome, login, senha, cpf, dataNascimento, perfil) 
values(1, 'Victor Alves', 'alves@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '753.001.654-98', '2000-05-04', 1);
insert into cliente (id, nome, login, senha, cpf, dataNascimento, perfil) 
values(2, 'Bruno barros', 'bbruno@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '023.396.158-08', '1995-03-01', 1);
insert into cliente (id, nome, login, senha, cpf, dataNascimento, perfil) 
values(3, 'Dany Bananinha', 'bananas@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '522.369.528-05', '1997-01-04', 1);
insert into cliente (id, nome, login, senha, cpf, dataNascimento, perfil) 
values(4, 'Eliana do SBT', 'eliana@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '001.311.102-15', '1998-02-02', 1);
insert into cliente (id, nome, login, senha, cpf, dataNascimento, perfil) 
values(5, 'Ana Vitoria', 'vitoriadaana@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '099.389.963-11', '1998-06-06', 1);
insert into cliente (id, nome, login, senha, cpf, dataNascimento, perfil) 
values(6, 'Ana ', 'vitoriadaana@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '099.389.963-11', '1998-06-06', 1);
insert into cliente (id, nome, login, senha, cpf, dataNascimento, perfil) 
values(7, 'Vitoria', 'vitoriadaana@unitins.br', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', '099.389.963-11', '1998-06-06', 1);


-- Clientes -> telefones
insert into cliente_telefone (id_cliente, id_telefone) values(1, 1);
insert into cliente_telefone (id_cliente, id_telefone) values(1, 2);
insert into cliente_telefone (id_cliente, id_telefone) values(2, 3);
insert into cliente_telefone (id_cliente, id_telefone) values(3, 4);
insert into cliente_telefone (id_cliente, id_telefone) values(4, 5);
insert into cliente_telefone (id_cliente, id_telefone) values(5, 6);
insert into cliente_telefone (id_cliente, id_telefone) values(5, 7);

-- Clientes -> endereços
insert into cliente_endereco (id_cliente, id_endereco) values(1, 1);
insert into cliente_endereco (id_cliente, id_endereco) values(2, 2);
insert into cliente_endereco (id_cliente, id_endereco) values(3, 3);
insert into cliente_endereco (id_cliente, id_endereco) values(2, 4);
insert into cliente_endereco (id_cliente, id_endereco) values(5, 5);
insert into cliente_endereco (id_cliente, id_endereco) values(6, 6);
insert into cliente_endereco (id_cliente, id_endereco) values(6, 7);

-- Pix
insert into pix (id, chavePix) values(1, 'carlos@gmail.com');
insert into pix (id, chavePix) values(2, '9998563254');

-- Boleto Bancario
insert into boletoBancario (id, banco, numeroBoleto, dataVencimento) 
values(1, 'Bradesco', '36985214789', '2026-05-03');
insert into boletoBancario (id, banco, numeroBoleto, dataVencimento) 
values(2, 'Next', '036985523', '2028-05-04');
insert into boletoBancario (id, banco, numeroBoleto, dataVencimento) 
values(3, 'Nubank', '951555887', '2024-02-05');

-- Cartão de Crédito
insert into cartaoCredito (id, bandeira, numeroCartao, codigoSeguranca, dataVencimento) 
values(1, 'Visa', '111225589', '123', '2024-03-08');
insert into cartaoCredito (id, bandeira, numeroCartao, codigoSeguranca, dataVencimento) 
values(2, 'Alguma', '111225589', '444', '2024-03-08');
insert into cartaoCredito (id, bandeira, numeroCartao, codigoSeguranca, dataVencimento) 
values(3, 'Visa', '111225589', '569', '2024-03-08');

-- Modelos

insert into modelo (id, nome, marca) values(1, 'Iphone Xr', 'Apple');
insert into modelo (id, nome, marca) values(2, 'A45', 'Samsung');
insert into modelo (id, nome, marca) values(3, 'Iphone X', 'Apple');
insert into modelo (id, nome, marca) values(4, 'A50', 'Samsung');

-- Capinhas

insert into capinha (id, nome, descricao, valor, quantEstoque, modelo_id, cor)
values(1, 'Capinha de Glitter', 'Uma capinha de celular', 25.0, 30, 1, 'AZUL');
insert into capinha (id, nome, descricao, valor, quantEstoque, modelo_id, cor)
values(2, 'Capinha de titânio ', 'Uma capinha de celular', 45.0, 5, 2, 'VERDE');
insert into capinha (id, nome, descricao, valor, quantEstoque, modelo_id, cor)
values(3, 'Capinha de Madeira ', 'Uma capinha de celular', 45.0, 5, 3, 'VERMELHO');
insert into capinha (id, nome, descricao, valor, quantEstoque, modelo_id, cor)
values(4, 'Capinha de titânio ', 'Uma capinha de celular', 45.0, 5, 4, 'TRANSPARENTE');
insert into capinha (id, nome, descricao, valor, quantEstoque, modelo_id, cor)
values(5, 'Capinha de Glitter ', 'Uma capinha de celular', 45.0, 5, 1, 'LARANJA');
