---select * from Empregado

---1
select NomeEmpregado from Empregado
	ORDER BY DataAdmissao ASC

---2
select NomeEmpregado, (Salario*12) as SalarioAnual from Empregado
	where Cargo = 'Atendente'
		or (Salario*12) < 18500

---3
select IDCidade from Cidade
where Nome = 'Uberlândia'

---4
select IDCidade, Nome from Cidade
	where UF = 'RS'