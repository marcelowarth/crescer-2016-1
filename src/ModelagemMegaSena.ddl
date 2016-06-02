-- Gerado por Oracle SQL Developer Data Modeler 4.1.3.901
--   em:        2016-05-31 15:08:30 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE Apostas
  (
    IDApostas                     INTEGER NOT NULL ,
    DataHora                      DATE NOT NULL ,
    Bolao                         CHAR (1) NOT NULL ,
    Concurso_IDConcurso           INTEGER NOT NULL ,
    ValoresAposta_IDValoresAposta INTEGER NOT NULL ,
    Numeros                       VARCHAR2 (50) NOT NULL
  ) ;
ALTER TABLE Apostas ADD CONSTRAINT Apostas_PK PRIMARY KEY ( IDApostas ) ;


CREATE TABLE Concurso
  (
    IDConcurso              INTEGER NOT NULL ,
    Data                    DATE NOT NULL ,
    Premio                  NUMBER (12,2) NOT NULL ,
    Percentual_IDPercentual INTEGER NOT NULL ,
    NumerosSorteados        VARCHAR2 (50)
  ) ;
ALTER TABLE Concurso ADD CONSTRAINT Concurso_PK PRIMARY KEY ( IDConcurso ) ;


CREATE TABLE Ganhadores
  (
    IDGanhador          INTEGER NOT NULL ,
    QtdeAcertos         INTEGER NOT NULL ,
    Apostas_IDApostas   INTEGER NOT NULL ,
    Concurso_IDConcurso INTEGER NOT NULL
  ) ;
ALTER TABLE Ganhadores ADD CONSTRAINT Ganhadores_PK PRIMARY KEY ( IDGanhador ) ;


CREATE TABLE Percentual
  (
    IDPercentual      INTEGER NOT NULL ,
    Sena              NUMBER (12,2) NOT NULL ,
    Quina             NUMBER (12,2) NOT NULL ,
    Quadra            NUMBER (12,2) NOT NULL ,
    Acumulado0ou5     NUMBER (12,2) NOT NULL ,
    AcumuladoFinalAno NUMBER (12,2) NOT NULL
  ) ;
ALTER TABLE Percentual ADD CONSTRAINT Percentual_PK PRIMARY KEY ( IDPercentual ) ;


CREATE TABLE ValoresAposta
  (
    IDValoresAposta INTEGER NOT NULL ,
    QtdeNumeros     INTEGER NOT NULL ,
    Valor           NUMBER (10,2) NOT NULL
  ) ;
ALTER TABLE ValoresAposta ADD CONSTRAINT ValoresAposta_PK PRIMARY KEY ( IDValoresAposta ) ;


ALTER TABLE Apostas ADD CONSTRAINT Apostas_Concurso_FK FOREIGN KEY ( Concurso_IDConcurso ) REFERENCES Concurso ( IDConcurso ) ;

ALTER TABLE Apostas ADD CONSTRAINT Apostas_ValoresAposta_FK FOREIGN KEY ( ValoresAposta_IDValoresAposta ) REFERENCES ValoresAposta ( IDValoresAposta ) ;

ALTER TABLE Concurso ADD CONSTRAINT Concurso_Percentual_FK FOREIGN KEY ( Percentual_IDPercentual ) REFERENCES Percentual ( IDPercentual ) ;

ALTER TABLE Ganhadores ADD CONSTRAINT Ganhadores_Apostas_FK FOREIGN KEY ( Apostas_IDApostas ) REFERENCES Apostas ( IDApostas ) ;

ALTER TABLE Ganhadores ADD CONSTRAINT Ganhadores_Concurso_FK FOREIGN KEY ( Concurso_IDConcurso ) REFERENCES Concurso ( IDConcurso ) ;


-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                             10
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
