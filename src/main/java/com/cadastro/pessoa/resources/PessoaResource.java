package com.cadastro.pessoa.resources;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cadastro.pessoa.entities.Pessoa;
import com.cadastro.pessoa.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
@CrossOrigin(origins = "http://localhost:3000")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	

	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {

		List<Pessoa> list = pessoaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id){
		Pessoa obj = pessoaService.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> insert(@Valid @RequestBody Pessoa obj) {

		obj = pessoaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getid()).toUri();
		return ResponseEntity.created(uri).body(obj);

	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return  ResponseEntity.noContent().build(); //204
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa obj){
		obj = pessoaService.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}

}
