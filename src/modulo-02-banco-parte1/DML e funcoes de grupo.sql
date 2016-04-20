--- select * from Empregado

---1
select SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) - 1) from Associado

---2
select Nome, datediff(year,DataNascimento,getDate()) as Idade from Associado

---3
select *, datediff(month,DataAdmissao,'2000-12-31') as MesesTrabalhados from Empregado
where DataAdmissao between ('1980-05-01') and ('1982-01-20')

---4
select TOP 1 Cargo, count(Cargo) as Total from Empregado group by Cargo order by Total DESC

---6
select nome, DATEADD(year, 50, DataNascimento) as Comp50Anos, DataNascimento from Associado

---7
select UF, count(nome) as NumCidades from Cidade Group by UF

---8
select Distinct Nome, UF from Cidade group by Nome, UF having (COUNT(*) > 1)

---9
select MAX(IDAssociado)+1 from Associado

---10
delete CidadeAux
insert into CidadeAux(IDCidade, Nome, UF)
	select distinct min(IDCidade), Nome, UF from Cidade group by Nome, UF

---11
---commit
---rollback
---begin transaction
update Cidade set Nome = CONCAT('*', Nome) where Nome IN (select Distinct Nome from Cidade group by Nome having (COUNT(*) > 1))

---12
select Nome,
	CASE sexo
		when 'F' Then 'Feminino'
		when 'M' Then 'Masculino'
		else 'sei la'
	End Genero
from Associado

---13
select NomeEmpregado, 
	salario,
	Case when salario <= 1164.0							then '0%'
		 when salario > 1164.0 and salario <= 2326.0	then '15%'
		 when salario > 2326.0							then '27.5%'
	END IR
from Empregado

---14
---commit
---rollback
---begin transaction
delete from cidade
where Nome IN (select Distinct Nome from Cidade group by Nome having (COUNT(*) > 1))
	and IDCidade NOT IN (select Distinct MIN(IDCidade) from Cidade group by Nome having (COUNT(*) > 1))

---15
---update Cidade 