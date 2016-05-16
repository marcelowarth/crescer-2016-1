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
  TABLE Produtos
  (
    id_produto    INTEGER IDENTITY NOT NULL ,
    nomeProduto   VARCHAR NOT NULL ,
    dataPedido    DATETIME NOT NULL ,
    dataEntrega   DATETIME NOT NULL ,
    valor         DECIMAL (10,2) NOT NULL ,
    tipoPagamento VARCHAR (50) NOT NULL ,
    cliente       VARCHAR (50) NOT NULL ,
    cidade        VARCHAR (50) NOT NULL ,
    estado        VARCHAR (50) NOT NULL ,
    urgente BIT NOT NULL
  )
  ON "default"
GO
ALTER TABLE Produtos ADD CONSTRAINT Produtos_PK PRIMARY KEY CLUSTERED (
id_produto)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

CREATE
  TABLE Usuario
  (
    id_usuario    INTEGER IDENTITY NOT NULL ,
    nome_usuario  VARCHAR (50) NOT NULL ,
    email_usuario VARCHAR (50) NOT NULL UNIQUE,
    senha_usuario VARCHAR (50) NOT NULL
  )
  ON "default"
GO
ALTER TABLE Usuario ADD CONSTRAINT Usuario_PK PRIMARY KEY CLUSTERED (id_usuario
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
REFERENCES Usuario
(
id_usuario
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO


