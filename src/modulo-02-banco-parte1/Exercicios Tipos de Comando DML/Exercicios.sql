---commit
---rollback

--- SP_HELP CidadeAux
--- select * from CidadeAux

begin transaction

---1
insert into Associado (IDAssociado, Nome, DataNascimento, CPF, Sexo) Values (3, 'Julio de Castilhos', convert(datetime, '14/12/1947', 103), '21234567895', 'M')
insert into Associado (IDAssociado, Nome, DataNascimento, CPF, Sexo) Values (4, 'Antonio Augusto Borges de Medeiros', convert(datetime, '19/03/1942', 103), '81234567891', 'M')
insert into Associado (IDAssociado, Nome, DataNascimento, CPF, Sexo) Values (5, 'Osvaldo Aranha', convert(datetime, '08/02/1958', 103), '01234567893', 'M')

---2
select * into CidadeAux From Cidade

---3
Truncate table CidadeAux
insert into CidadeAux (IDCidade, Nome, UF) select * from Cidade

---4
Create table Produto 
(
  IDProduto				int IDENTITY        not null,
  Nome_Curto			varchar(10)			not null,
  Nome_Descritivo		varchar(30)			not null,
  DataCriacao			datetime			not null,
  Local_Estoque			varchar(30)			not null,
  Qtde					int					not null DEFAULT 0,
  Preco					float				not null,
    constraint PK_Produto primary key (IDProduto)
);	

---5
insert into Produto (Nome_Curto, Nome_Descritivo, DataCriacao, Local_Estoque, Qtde, Preco) Values ('AJAX', 'Agua Sanitaria', getDate(), 'Prateleira C', 20, 10.5)
insert into Produto (Nome_Curto, Nome_Descritivo, DataCriacao, Local_Estoque, Qtde, Preco) Values ('Negresco', 'Bolacha', getDate(), 'Prateleira A', 100, 0.5)
--- select * from Produto