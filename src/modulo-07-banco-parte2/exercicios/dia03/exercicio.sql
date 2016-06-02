DECLARE
  vCountInd     integer := 0;
  vCountSena    integer := 0;
  vCountQuina   integer := 0;
  vCountQuadra  integer := 0;
BEGIN
  FOR d IN (select NUMEROS from ARQUIVO_APOSTA_B) LOOP
    FOR i IN (select conc.PRIMDEZENA, conc.SEGDEZENA, conc.TERDEZENA, conc.QUADEZENA, conc.QUIDEZENA, conc.SEXDEZENA from ARQUIVO_CONCURSO conc) LOOP
      IF (INSTR(d.NUMEROS,' '||i.PRIMDEZENA||'|') > 0) THEN
        vCount := vCount + 1;
      END IF;
      IF (INSTR(d.NUMEROS,' '||i.SEGDEZENA||'|') > 0) THEN
        vCount := vCount + 1;
      END IF;
      IF (INSTR(d.NUMEROS,' '||i.TERDEZENA||'|') > 0) THEN
        vCount := vCount + 1;
      END IF;
      IF (INSTR(d.NUMEROS,' '||i.QUADEZENA||'|') > 0) THEN
        vCount := vCount + 1;
      END IF;
      IF (INSTR(d.NUMEROS,' '||i.QUIDEZENA||'|') > 0) THEN
        vCount := vCount + 1;
      END IF;
      IF (INSTR(d.NUMEROS,' '||i.SEXDEZENA||'|') > 0) THEN
        vCount := vCount + 1;
      END IF;
      IF(vCount = 6) THEN
        vCountSena := vCountSena + 1;
      END IF;
      IF(vCount = 5) THEN
        vCountQuina := vCountQuina + 1;
      END IF;
      IF(vCount = 4) THEN
        vCountQuadra := vCountQuadra + 1;
      END IF;
    END LOOP;
    vCount := 0;
  END LOOP;
  DBMS_OUTPUT.put_line(vCountSena);
  DBMS_OUTPUT.put_line(vCountQuina);
  DBMS_OUTPUT.put_line(vCountQuadra);
END;
