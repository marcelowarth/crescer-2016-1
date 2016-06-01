-- 1)
select IDCliente, cli.Nome, cid.NOME as Cidade, UF from Cliente cli
join CIDADE cid on cli.IDCIDADE = cid.IDCIDADE;

-- 2)
select count(*) from PEDIDO where EXTRACT(month from DATAPEDIDO) = 5 and EXTRACT(year from DATAPEDIDO) = 2016;

-- 3)
select * from CLIENTE where lower(NOME) like '%ltda%' or lower(RAZAOSOCIAL) like '%ltda%';

-- 4)
insert into PRODUTO (idproduto, nome, datacadastro, PRECOCUSTO, precovenda, situacao)
values (sqproduto.nextval, 'Galocha Maragato', SYSDATE, 35.57, 77.95, 'A');
--commit;
--create sequence SQPRODUTO START WITH 8001;

-- 5)
select prod.* from PRODUTO prod
where prod.IDPRODUTO not in (
  select pItem.IDPRODUTO from PEDIDOITEM pItem
);

-- 6)
select * from PEDIDO where IDCLIENTE = :pIDCliente;

-- 7)
select sum(PEDIDOITEM.QUANTIDADE) from PEDIDOITEM 
join PEDIDO on PEDIDOITEM.IDPEDIDO = PEDIDO.IDPEDIDO
where IDPRODUTO = :pIDProduto 
and EXTRACT(year from PEDIDO.DATAPEDIDO) = 2016;

-- 8)
select  TO_CHAR(ped.DATAPEDIDO, 'MM/YYYY') as MesAno,
        count(distinct pItem.IDProduto) as Prod_Distintos,
        count(distinct ped.IDPedido) as total_Pedidos,
        SUM(ped.VALORPEDIDO) as Valor_Pedidos,
        MIN(ped.VALORPEDIDO) as Menor_Valor,
        MAX(ped.VALORPEDIDO) as Maior_Valor,
        AVG(ped.VALORPEDIDO) as Media_Valor
from PEDIDO ped
join PEDIDOITEM pItem on pItem.IDPEDIDO = ped.IDPEDIDO
group by TO_CHAR(ped.DATAPEDIDO, 'MM/YYYY');






