--1) Selecione o nome do empregado e nome do departamento que cada um está relacionado. 
select e.NomeEmpregado, d.NomeDepartamento from Empregado e
	join Departamento d ON e.IDDepartamento = d.IDDepartamento

--2) Exibir o nome do associado e sua cidade, exibir também associados sem Cidade relacionada.
select a.Nome, c.Nome as Cidade from Associado a
	Left join cidade c ON c.IDCidade = a.IDCidade

--3) Lista os estados (UF) e total de cidades, exibir apenas as cidades que não possuem associados relacionados.
--Exemplo: UF Total_Cidades
--RS 10
--SP 5
select UF, count(c.Nome) as QtdCidades from cidade c
	left join Associado a ON a.IDCidade = c.IDCidade
	where a.IDCidade is null
	group by c.UF

--4) Faça uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade é da 
--região SUL (RS, SC, PR), se for imprimir *** (3 asteriscos), senão imprimir nulo.
select a.Nome, c.nome as Cidade, 
	(Case 
		WHEN c.UF IN ('RS', 'SC', 'PR') then '***'
		ELSE null
		end ) as ESul
	from Associado a
	left join Cidade c ON c.IDCidade = a.IDCidade

--5) Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
select e.NomeEmpregado, d2.NomeDepartamento as DepEmp, 
		g.NomeEmpregado as Gerente, d.NomeDepartamento as DepGerente 
	from Empregado e
	left join Empregado g ON e.IDGerente = g.IDEmpregado
	left join Departamento d ON g.IDDepartamento = d.IDDepartamento
	Left join Departamento d2 on e.IDDepartamento = d2.IDDepartamento

--6) Faça uma cópia da tabela Empregado e altere o salário de todos os empregados (Empregado) que o departamento 
--fique na localidade de SAO PAULO, faça um reajuste de 14,5%
select * into EmpregadoAux from Empregado
update EmpregadoAux set salario = (Salario*1.145) where IDEmpregado IN (
	select IDEmpregado from EmpregadoAux ea
	left join Departamento d on ea.IDDepartamento = d.IDDepartamento
	where d.Localizacao = 'SAO PAULO')

--7) Liste a diferença  que representará o reajuste aplicado no item anterior no somatório dos salários de todos os 
--empregados.
select (SUM(ea.Salario)-SUM(e.Salario)) as Diferenca, 
		SUM(e.Salario) as Original,  
		SUM(ea.Salario) as Novo
		from Empregado e
	JOIN EmpregadoAux ea ON e.IDEmpregado = ea.IDEmpregado

--8) Liste o departamento com o empregado de maior salário.
select * from Departamento
	JOIN (
			select TOP 1 IDDepartamento, MAX(Salario) Salario from Empregado group by IDDepartamento ORDER BY Salario DESC
		) Emp ON Departamento.IDDepartamento = Emp.IDDepartamento

--9) Faça uma consulta para exibir o nome de cada associado e sua cidade e juntamente com os empregados (nome) e a 
--cidade (localidade) de seu departamento, isto deve ser exibido em uma consulta. 
select a.Nome, c.Nome from Associado a
	LEFT JOIN Cidade c ON c.IDCidade = a.IDCidade
UNION ALL
select e.NomeEmpregado, d.Localizacao from Empregado e
	LEFT JOIN Departamento d ON e.IDDepartamento = d.IDDepartamento

--10) Lista as cidades que tenham associado relacionados. Exibr: Nome e UF apenas
select c.Nome, c.UF from Cidade c
	JOIN Associado a ON c.IDCidade = a.IDCidade