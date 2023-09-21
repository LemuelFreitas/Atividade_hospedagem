package com.projetojpahospedagem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpahospedagem.entities.Funcionario;
import com.projetojpahospedagem.services.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscaFuncionarioControlId(@PathVariable long Codigo) {
		Funcionario funcionario = funcionarioService.buscaFuncionarioId(Codigo);
		if (funcionario != null)
			return ResponseEntity.ok(funcionario);
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> buscaTodosFuncionarioControl() {
		List<Funcionario> Funcionario = funcionarioService.buscaTodosFuncionario();
		return ResponseEntity.ok(Funcionario);
	}

	@PostMapping("/")
	public ResponseEntity<Funcionario> salvaFuncionarioControl(@RequestBody Funcionario funcionario) {
		Funcionario salvaFuncionario = funcionarioService.salvaFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaFuncionario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> alteraFuncionarioControl(@PathVariable long codigo, @RequestBody Funcionario funcionario) {
		Funcionario alteraFuncionario = funcionarioService.alterarFuncionario(codigo, funcionario);
		if (alteraFuncionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaFuncionarioControl(@PathVariable long codigo) {
		boolean apagar = funcionarioService.apagarFuncionario(codigo);
		if (apagar) {
			return ResponseEntity.ok().body("O Funcionario foi excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();

		}
	}
}