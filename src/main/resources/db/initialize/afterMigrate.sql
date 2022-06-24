delete from veiculo;

alter table veiculo alter column id restart with 1;

insert into veiculo (nome, marca, modelo, ano_fabricacao, consumo_cidade, consumo_rodovia) values ('Renegade', 'JEEP', 'Limited', 2017, 8, 13);
insert into veiculo (nome, marca, modelo, ano_fabricacao, consumo_cidade, consumo_rodovia) values ('Fiesta', 'Ford', 'SEL', 2017, 9, 15);
insert into veiculo (nome, marca, modelo, ano_fabricacao, consumo_cidade, consumo_rodovia) values ('Hyundai', 'I30', '2.0', 2012, 8, 14);