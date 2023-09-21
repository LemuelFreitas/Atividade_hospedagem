package com.projetojpahospedagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpahospedagem.entities.Funcionario;
import com.projetojpahospedagem.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public List<Funcionario> buscaTodosFuncionario() {
		return funcionarioRepository.findAll();
	}

	public Funcionario buscaFuncionarioId(long codigo) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(codigo);
		return funcionario.orElse(null);
	}

	// metodo para salver os produtos
	public Funcionario salvaFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public Funcionario alterarFuncionario(long codigo, Funcionario alterarFunc) {
		Optional<Funcionario> existeFuncionario = funcionarioRepository.findById(codigo);
		if (existeFuncionario.isPresent()) {
			alterarFunc.setCodigo(codigo);
			return funcionarioRepository.save(alterarFunc);

		}
		return null;
	}
	public boolean apagarFuncionario(long codigo) {
		Optional<Funcionario> existeFuncionario = funcionarioRepository.findById(codigo);
		if (existeFuncionario.isPresent() ) {
			funcionarioRepository.deleteById(codigo);
			return true;
		}
		return false;
	}
}

