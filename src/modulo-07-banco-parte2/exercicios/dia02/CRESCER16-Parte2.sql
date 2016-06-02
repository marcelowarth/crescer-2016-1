--1) Crie um procedimento que receba por par�metro o IDPedido e atualize o valor do pedido conforme seus itens.
--? Valor unit�rio * Quantidade
CREATE OR REPLACE PROCEDURE ATUALIZA_VALOR_PEDIDO (pIDPedido in integer) AS
BEGIN
  UPDATE PEDIDO ped 
  SET ped.VALORPEDIDO = (SELECT SUM(pItem.QUANTIDADE*pItem.PRECOUNITARIO) 
                          FROM PEDIDOITEM pItem 
                          WHERE pItem.IDPedido = ped.IDPedido)
  WHERE ped.IDPEDIDO = pIDPedido;
END;

--2) Crie uma fun��o que receba por par�metro o IDCliente e retorne a data do �ltimo pedido realizado pelo cliente.
CREATE OR REPLACE FUNCTION ULTIMO_PEDIDO (pIDCliente in integer) RETURN PEDIDO.DATAPEDIDO%type AS
  vUltPed PEDIDO.DATAPEDIDO%type;
BEGIN
  SELECT MAX(DATAPEDIDO)
  INTO vUltPed
  FROM PEDIDO
  WHERE IDCLIENTE = pIDCliente;
  
  RETURN vData;
END;

--3) Crie uma fun��o que receba por par�metro o IDProduto e o per�odo (m�s e ano) e retorne a quantidade (total)
--desde produtos vendidos no per�odo (considere todos os dias do m�s).
CREATE OR REPLACE FUNCTION PRODUTOS_PERIODO (pIDProduto in integer, pData in DATE) RETURN PEDIDOITEM.QUANTIDADE%type AS
  vQtde PEDIDOITEM.QUANTIDADE%type;
BEGIN
  SELECT SUM(pItem.QUANTIDADE)
  INTO vQtde
  FROM PEDIDOITEM pItem
  JOIN PEDIDO ped on pItem.IDPEDIDO = ped.IDPEDIDO
  WHERE ped.DATAPEDIDO BETWEEN TRUNC(pData, 'MM') AND LAST_DAY(pData)
    AND pItem.IDPRODUTO = pIDProduto;
    
  RETURN vQtde;
END;






