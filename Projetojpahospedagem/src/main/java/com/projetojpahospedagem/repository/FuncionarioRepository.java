package com.projetojpahospedagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpahospedagem.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}