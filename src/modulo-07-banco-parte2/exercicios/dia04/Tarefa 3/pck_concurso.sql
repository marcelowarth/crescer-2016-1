create or replace package PCK_CONCURSO is

  -- Author  : ANDRENUNES
  -- Created : 03/06/2016 10:40:29
  -- Purpose : Gerar informações reference a cada concurso
  
  -- Public type declarations
  procedure geraProximoConcurso;
  procedure atualizaAcertadores;

end PCK_CONCURSO;
/

create or replace package body PCK_CONCURSO is

  -- Private type declarations
  
  /* Conforme especificacao deve gerar 1 registro na tabela concurso */
  procedure geraProximoConcurso as
       vConcurso      CONCURSO.IDCONCURSO%type;
       vValor         APOSTA.VALOR%type;
       vAcumulou      CONCURSO.ACUMULOU%type;
       vSena          CONCURSO.PREMIO_SENA%type := 0;
       vData          CONCURSO.DATA_SORTEIO%type;
       vDias          integer := 4;
    begin      
        select MAX(conc.IDCONCURSO), SUM(apo.VALOR), conc.ACUMULOU
        into vConcurso, vValor, vAcumulou
        from CONCURSO conc
        join APOSTA apo on conc.IDCONCURSO = apo.IDCONCURSO 
        group by conc.ACUMULOU;
        IF(vAcumulou != 0) THEN
          select PREMIO_SENA
          into vSena
          from CONCURSO
          where IDCONCURSO = vConcurso;
        END IF;
        select DATA_SORTEIO
        into vData
        from CONCURSO;
        IF(TO_CHAR(vData, 'D') = 4) THEN
          vDias := 3;
        END IF;
        salvaConcurso(vConcurso+1, SYSDATE+vDias, (vValor*0.453)+vSena);
        COMMIT;
    end;
  ----------------------------------------------------------------------
  /* Conforme especificacao deve atualizar a tabela de acertadores */    
  procedure atualizaAcertadores(pIDConcurso in integer) as
    cursor c_aposta is
      select IDAPOSTA, IDCONCURSO
      from APOSTA
      where IDCONCURSO = pIDConcurso;
    
    cursor c_numeros(pIDAposta in integer) is
      select NUMERO
      from NUMERO_APOSTA
      WHERE IDAPOSTA = pIDAposta;
      
    vSena integer := 0;
    vQuina integer := 0;
    vQuadra integer := 0;
    vCount integer;
    vPrim integer;
    vSeg integer;
    vTer integer;
    vQua integer;
    vQui integer;
    vSex integer;
  BEGIN
    select PRIMEIRA_DEZENA, SEGUNDA_DEZENA, TERCEIRA_DEZENA, QUARTA_DEZENA, QUINTA_DEZENA, SEXTA_DEZENA
    into vPrim, vSeg, vTer, vQua, vQui, vSex
    from CONCURSO
    where IDCONCURSO = pIDConcurso;
    
    for i in c_aposta loop
       for j in c_numeros (i.IDAPOSTA) loop
          if(j.NUMERO in (vPrim, vSeg, vTer, vQua, vQui, vSex)) then
            vCount := vCount + 1;
          end if;
       end loop;
       if(vCount = 6) then
        vSena := vSena + 1;
       elsif (vCount = 5) then
        vQuina := vQuina + 1;
       elsif (vCount = 4) then
        vQuadra := vQuadra + 1;
       end if;
       vCount := 0;
    end loop;
    if(vSena = 0) then
      UPDATE CONCURSO SET ACUMULOU = 1 WHERE IDCONCURSO = pIDConcurso;
    end if;
  END;
  ----------------------------------------------------------------------
  
begin
  -- Initialization
  null;
end PCK_CONCURSO;
/
