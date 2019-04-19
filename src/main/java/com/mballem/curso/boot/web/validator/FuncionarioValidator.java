package com.mballem.curso.boot.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mballem.curso.boot.domain.Funcionario;

/**
 * SPRING VALIDATOR
 * @author Arivaldo
 *
 */
public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Funcionario f = (Funcionario) target;
		LocalDate entrada = f.getDataEntrada();
		LocalDate saida = f.getDataSaida();
		
		if(entrada != null && saida != null) {
			if(saida.isBefore(entrada)) {
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
			}
		}
	}

}
