package com.projetojpahospedagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpahospedagem.entities.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {
	

}