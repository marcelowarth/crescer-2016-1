-- 1)
select IDCliente, cli.Nome, cid.NOME as Cidade, UF from Cliente cli
join CIDADE cid on cli.IDCIDADE = cid.IDCIDADE;

-- 2)
select count(*)  from PEDIDO where EXTRACT(month from DATAPEDIDO) = 5 and EXTRACT(year from DATAPEDIDO) = 2016;

-- 3)
select * from CLIENTE where NOME like '%ltda%' or RAZAOSOCIAL like '%ltda%';

-- 4)
insert into PRODUTO (idproduto, nome, datacadastro, PRECOCUSTO, precovenda, situacao)
values (sqproduto.nextval, 'Galocha Maragato', SYSDATE, 35.57, 77.95, 'A');
--commit;
--create sequence SQPRODUTO START WITH 8001;

