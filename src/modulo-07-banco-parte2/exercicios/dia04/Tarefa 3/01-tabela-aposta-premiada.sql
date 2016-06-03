create table Aposta_Premiada (
  idaposta_premiada    integer      not null,
  idaposta             integer      not null,
  acertos              number(1)    not null,
  valor                number(12,2) not null,
    constraint PK_Aposta_Premiada primary key (IDAposta_Premiada)
);
