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

import com.projetojpahospedagem.entities.Aposento;
import com.projetojpahospedagem.services.AposentoService;

@RestController
@RequestMapping("/aposento")
public class AposentoController {
	private final AposentoService aposentoService;

	@Autowired
	public AposentoController(AposentoService aposentoService) {
		this.aposentoService = aposentoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aposento> buscaAposentoControlId(@PathVariable long Codigo) {
		Aposento aposento = aposentoService.buscaAposentoId(Codigo);
		if (aposento != null)
			return ResponseEntity.ok(aposento);
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Aposento>> buscaTodosAposentoControl() {
		List<Aposento> Aposento = aposentoService.buscaTodosAposento();
		return ResponseEntity.ok(Aposento);
	}

	@PostMapping("/")
	public ResponseEntity<Aposento> salvaAposentoControl(@RequestBody Aposento aposento) {
		Aposento salvaAposento = aposentoService.salvaAposento(aposento);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAposento);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Aposento> alteraAposentoControl(@PathVariable long codigo, @RequestBody Aposento aposento) {
		Aposento alteraAposento = aposentoService.alterarAposento(codigo, aposento);
		if (alteraAposento != null) {
			return ResponseEntity.ok(aposento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaAposentoControl(@PathVariable long codigo) {
		boolean apagar = aposentoService.apagarAposento(codigo);
		if (apagar) {
			return ResponseEntity.ok().body("O Aposento foi excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();

		}
	}
}