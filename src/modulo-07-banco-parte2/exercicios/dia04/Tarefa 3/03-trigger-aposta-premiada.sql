Create Trigger TR_SQ_APOSTA_PREMIADA
 before insert on APOSTA_PREMIADA
 for each row when (new.IDAPOSTA_PREMIADA is null) 
Begin 
 Select SQAPOSTA_PREMIADA.nextval into :new.IDAPOSTA_PREMIADA from dual; 
End TR_SQ_APOSTA_PREMIADA;
/
