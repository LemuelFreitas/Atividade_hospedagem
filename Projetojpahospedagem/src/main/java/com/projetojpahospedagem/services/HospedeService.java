package com.projetojpahospedagem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpahospedagem.entities.Hospede;
import com.projetojpahospedagem.repository.HospedeRepository;

@Service
public class HospedeService {
	private final HospedeRepository hospedeRepository;

	@Autowired
	public HospedeService(HospedeRepository hospedeRepository) {
		this.hospedeRepository = hospedeRepository;
	}

	public List<Hospede> buscaTodosHospede() {
		return hospedeRepository.findAll();
	}

	public Hospede buscaHospedeId(long codigo) {
		Optional<Hospede> hospede = hospedeRepository.findById(codigo);
		return hospede.orElse(null);
	}

	
	public Hospede salvaHospede(Hospede hospede) {
		return hospedeRepository.save(hospede);
	}

	public Hospede alterarHospede(long codigo, Hospede alterarHosp) {
		Optional<Hospede> existeHospede = hospedeRepository.findById(codigo);
		if (existeHospede.isPresent()) {
			alterarHosp.setCodigo(codigo);
			return hospedeRepository.save(alterarHosp);

		}
		return null;
	}
	public boolean apagarHospede(long codigo) {
		Optional<Hospede> existeHospede = hospedeRepository.findById(codigo);
		if (existeHospede.isPresent() ) {
			hospedeRepository.deleteById(codigo);
			return true;
		}
		return false;
	}
}