--1) Crie um procedimento que receba por parâmetro o IDPedido e atualize o valor do pedido conforme seus itens.
--? Valor unitário * Quantidade
CREATE OR REPLACE PROCEDURE ATUALIZA_VALOR_PEDIDO (pIDPedido in integer) AS
BEGIN
  UPDATE PEDIDO ped 
  SET ped.VALORPEDIDO = (SELECT SUM(pItem.QUANTIDADE*pItem.PRECOUNITARIO) 
                          FROM PEDIDOITEM pItem 
                          WHERE pItem.IDPedido = ped.IDPedido)
  WHERE ped.IDPEDIDO = pIDPedido;
END;

--2) Crie uma função que receba por parâmetro o IDCliente e retorne a data do último pedido realizado pelo cliente.
CREATE OR REPLACE FUNCTION ULTIMO_PEDIDO (pIDCliente in integer) RETURN PEDIDO.DATAPEDIDO%type AS
  vUltPed PEDIDO.DATAPEDIDO%type;
BEGIN
  SELECT MAX(DATAPEDIDO)
  INTO vUltPed
  FROM PEDIDO
  WHERE IDCLIENTE = pIDCliente;
  
  RETURN vData;
END;

--3) Crie uma função que receba por parâmetro o IDProduto e o período (mês e ano) e retorne a quantidade (total)
--desde produtos vendidos no período (considere todos os dias do mês).
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






