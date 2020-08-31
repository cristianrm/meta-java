package com.cadastro.pessoa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.cadastro.pessoa.entities.*;

import com.cadastro.pessoa.repository.PessoaRepository;
import com.cadastro.pessoa.services.exceptions.ResourceNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
		
	}
	
	public Pessoa findById(Long id) {
		 Optional<Pessoa> obj = pessoaRepository.findById(id);
		 return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Pessoa insert(Pessoa obj) {
		return pessoaRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			pessoaRepository.deleteById(id);	
		}catch (EmptyResultDataAccessException e) {
			
		}
		
	}
	
	public Pessoa update(Long id, Pessoa obj) {
		Pessoa pessoa = pessoaRepository.getOne(id);
		updateData(pessoa, obj);
		return pessoaRepository.save(pessoa);
		
		
	}
	
	public void updateData(Pessoa pessoa, Pessoa obj) {
		pessoa.setNome(obj.getNome());
		pessoa.setCpf(obj.getCpf());
		pessoa.setDataNascimento(obj.getDataNascimento());
		pessoa.setEmail(obj.getEmail());
		pessoa.setNaturalidade(obj.getNaturalidade());
		pessoa.setSexo(obj.getNaturalidade());
	}
}
