-- 1)
/* 1) Consultando cliente
? Fa�a um bloco PL/SQL que receba UM par�metro (em tempo de execu��o apenas): IDCliente, e ent�o
pesquise nome do cliente e cidade (caso tenha), e outras informa��es referente a pedidos:
o Data da primeira compra (pedido) realizado;
o Data da �ltima compra realizada.
o Valor total dos pedidos, quantidade de pedidos e m�dia de valor dos pedidos.

DECLARE
  vNome             CLIENTE.NOME%type;
  vCidade           CIDADE.NOME%type;
  vPrimPedido       PEDIDO.DATAPEDIDO%type;
  vUltPedido        PEDIDO.DATAPEDIDO%type;
  vSomaPedidos      PEDIDO.VALORPEDIDO%type;
  vQtdePedidos      PEDIDO.IDPEDIDO%type;
  vMediaPedidos     PEDIDO.VALORPEDIDO%type;
begin

select cli.NOME, cid.NOME as Cidade, MIN(ped.DATAPEDIDO) as Primeiro_Pedido, MAX(ped.DATAPEDIDO) as Ultimo_Pedido, 
      SUM(ped.VALORPEDIDO) as Total_Pedidos, COUNT(ped.IDPEDIDO) as QtdePedidos, AVG(ped.VALORPEDIDO) as Media_Pedidos
into vNome, vCidade, vPrimPedido, vUltPedido, vSomaPedidos, vQtdePedidos, vMediaPedidos
from CLIENTE cli
join CIDADE cid on cli.IDCIDADE = cid.IDCIDADE
join PEDIDO ped on ped.IDCLIENTE = cli.IDCLIENTE
where cli.IDCliente = &pIDCliente 
group by cli.NOME, cid.NOME;

DBMS_OUTPUT.PUT_LINE('Nome Cliente: ' || vNome || ' Cidade: ' || vCidade || ' Primeiro Pedido: ' || vPrimPedido 
                      || ' Ultimo Pedido: '  || vUltPedido || ' Qtde Pedidos: ' || vQtdePedidos 
                      || ' Total pedidos: ' || vSomaPedidos || ' Media Pedidos: ' || vMediaPedidos);

end;
*/
-- 2)
/*Fa�a um bloco PL/SQL que receba DOIS par�metros (em tempo de execu��o apenas): nome e uf, verifique
se j� existe um registro em Cidade para a combina��o, caso n�o exista fa�a um INSERT na tabela de Cidade.
o Utilize uma SEQUENCE para gerar o pr�ximo ID v�lido;
o Ignore o case sensitive na valida��o.
o Se j� existir a cidade+uf deve imprimir uma mensagem informando.*/
DECLARE
  vCidade     CIDADE.NOME%type;
  vUF         CIDADE.UF%type;
  vCount      integer;
BEGIN

vCidade := '&pCidade'; 
vUF     := '&pUF';

select count(*) 
into vCount
from CIDADE 
where lower(NOME) = lower(vCidade)
and lower(UF) = lower(vUF);


IF(vCount = 0) THEN 
  INSERT INTO CIDADE VALUES (sqcidade.nextval, vCidade, vUF);
ELSE 
  DBMS_OUTPUT.PUT_LINE('J� existe uma Cidade com esta UF!!');
END IF;

END;
--select * from CIDADE
--Irineopolis
