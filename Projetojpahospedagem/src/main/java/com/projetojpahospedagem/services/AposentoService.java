package com.projetojpahospedagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpahospedagem.entities.Aposento;

import com.projetojpahospedagem.repository.AposentoRepository;

@Service
public class AposentoService {
	private final AposentoRepository AposentoRepository;
	
	@Autowired
	public AposentoService(AposentoRepository aposentoRepository) {
		this.AposentoRepository = aposentoRepository;
	}

	public List<Aposento> buscaTodosAposento() {
		return AposentoRepository.findAll();
	}

	public Aposento buscaAposentoId(long codigo) {
		Optional<Aposento> aposento = AposentoRepository.findById(codigo);
		return aposento.orElse(null);
	}

	
	public Aposento salvaAposento(Aposento aposento) {
		return AposentoRepository.save(aposento);
	}

	public Aposento alterarAposento(long codigo, Aposento alterarApos) {
		Optional<Aposento> existeAposento = AposentoRepository.findById(codigo);
		if (existeAposento.isPresent()) {
			alterarApos.setCodigo(codigo);
			return AposentoRepository.save(alterarApos);

		}
		return null;
	}
	public boolean apagarAposento(long codigo) {
		Optional<Aposento> existeAposento = AposentoRepository.findById(codigo);
		if (existeAposento.isPresent() ) {
			AposentoRepository.deleteById(codigo);
			return true;
		}
		return false;
	}
}
