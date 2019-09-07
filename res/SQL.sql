CREATE OR REPLACE FUNCTION andamento_pesquisa(data1 date, data2 date)
  RETURNS double precision AS
$BODY$

DECLARE porcentagem FLOAT;
DECLARE dias_decorridos FLOAT;
DECLARE dias_totais FLOAT;

BEGIN 
	SELECT ABS(data1 - CURRENT_DATE) INTO dias_decorridos;
	SELECT ABS(data1 - data2) INTO dias_totais;
	IF(dias_totais = 0)
	THEN
		SELECT 100 INTO porcentagem; 
	ELSE
		SELECT (CAST(dias_decorridos AS FLOAT)/CAST(dias_totais as FLOAT))*100 INTO porcentagem; 
	END IF;
	
	RETURN porcentagem;
END; $BODY$
  LANGUAGE plpgsql VOLATILE
