CREATE
  TABLE Permisoes
  (
    id_permissao INTEGER IDENTITY NOT NULL ,
    permissao    VARCHAR (50) NOT NULL
  )
  ON "default"
GO
ALTER TABLE Permisoes ADD CONSTRAINT Permisoes_PK PRIMARY KEY CLUSTERED (
id_permissao)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

CREATE
  TABLE Pedidos
  (
    id_pedido    INTEGER IDENTITY NOT NULL ,
    nomeProduto   VARCHAR (50) NOT NULL ,
    dataPedido    DATETIME NOT NULL ,
    dataEntrega   DATETIME NOT NULL ,
    valor         DECIMAL (10,2) NOT NULL ,
    tipoPagamento INTEGER NOT NULL ,
    cliente       VARCHAR (50) NOT NULL ,
    cidade        VARCHAR (50) NOT NULL ,
    estado        VARCHAR (50) NOT NULL ,
    urgente BIT NOT NULL
  )
  ON "default"
GO
ALTER TABLE Pedidos ADD CONSTRAINT Pedido_PK PRIMARY KEY CLUSTERED (
id_pedido)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

CREATE
  TABLE Usuarios
  (
    id_usuario    INTEGER IDENTITY NOT NULL ,
    nome_usuario  VARCHAR (50) NOT NULL ,
    email_usuario VARCHAR (50) NOT NULL UNIQUE,
    senha_usuario VARCHAR (50) NOT NULL
  )
  ON "default"
GO
ALTER TABLE Usuarios ADD CONSTRAINT Usuario_PK PRIMARY KEY CLUSTERED (id_usuario
)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

CREATE
  TABLE Usuarios_Permissoes
  (
    id_usuario_permissao INTEGER IDENTITY NOT NULL ,
    id_usuario           INTEGER NOT NULL ,
    id_permissao         INTEGER NOT NULL
  )
  ON "default"
GO
ALTER TABLE Usuarios_Permissoes ADD CONSTRAINT Relation_1_PK PRIMARY KEY
CLUSTERED (id_usuario_permissao)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

ALTER TABLE Usuarios_Permissoes
ADD CONSTRAINT FK_Permissoes FOREIGN KEY
(
id_permissao
)
REFERENCES Permisoes
(
id_permissao
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Usuarios_Permissoes
ADD CONSTRAINT FK_Usuario FOREIGN KEY
(
id_usuario
)
REFERENCES Usuarios
(
id_usuario
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO


insert into Permisoes (permissao) values ('admin');
insert into Permisoes (permissao) values ('comum');

insert into Usuarios (nome_usuario, email_usuario, senha_usuario) values ('admin', 'admin@admin.com', 'd4ce3a95a07dc7a98983adbe3d4c0af0'); -- aDm1n
insert into Usuarios (nome_usuario, email_usuario, senha_usuario) values ('comum', 'comum@comum.com', '9f8c8017d55b36bfe68bc6fdbfa248f8'); -- c0Mum

SET IDENTITY_INSERT Usuarios_Permissoes OFF

insert into Usuarios_Permissoes (id_usuario, id_permissao) values (1, 1);
insert into Usuarios_Permissoes (id_usuario, id_permissao) values (1, 2);
insert into Usuarios_Permissoes (id_usuario, id_permissao) values (2, 2);

SET IDENTITY_INSERT Usuarios_Permissoes ON


insert into Pedidos (dataPedido, dataEntrega, nomeProduto, tipoPagamento, cidade, estado, cliente, urgente, valor) 
	values  (getDate(), getDate(), 'Kunai', 3, 'SL', 'RS', 'Nunes', 1, 1200.50);
	
insert into Pedidos (dataPedido, dataEntrega, nomeProduto, tipoPagamento, cidade, estado, cliente, urgente, valor) 
	values (getDate(), getDate(), 'Shuriken', 4, 'SL', 'RS', 'BenHur', 1, 1200.50);
	
insert into Pedidos (dataPedido, dataEntrega, nomeProduto, tipoPagamento, cidade, estado, cliente, urgente, valor) 
	values (getDate(), getDate(), 'Kunai', 3, 'SL', 'RS', 'Nunes', 1, 1200.50);