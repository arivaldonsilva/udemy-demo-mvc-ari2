package com.mballem.curso.boot.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mballem.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

	@Override
	public List<Funcionario> findByNome(String nome) {		
		return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%')", nome);
	}

	@Override
	public List<Funcionario> findByCargo(Long cargo) {		
		return createQuery("select f from Funcionario f where f.cargo.id = ?1 ", cargo);
	}

	@Override
	public List<Funcionario> findByDataEntradaSaida(LocalDate entrada, LocalDate saida) {
		return createQuery("select f from Funcionario f where f.dataEntrada >= ?1 and f.dataSaida <= ?2 order by f.dataEntrada asc", entrada, saida);
	}

	@Override
	public List<Funcionario> findByDataSaida(LocalDate saida) {
		return createQuery("select f from Funcionario f where f.dataSaida = ?1  order by f.dataSaida asc", saida);
	}

	@Override
	public List<Funcionario> findByDataEntrada(LocalDate entrada) {
		return createQuery("select f from Funcionario f where f.dataEntrada = ?1  order by f.dataEntrada asc", entrada);
	}

}
