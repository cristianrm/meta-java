package com.cadastro.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.pessoa.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
