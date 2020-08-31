package com.cadastro.pessoa;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cadastro.pessoa.entities.Pessoa;
import com.cadastro.pessoa.repository.PessoaRepository;
import com.cadastro.pessoa.services.PessoaService;

@Configuration
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	public PessoaService pessoaService;
	
	public PessoaRepository pessoaRepository;
	

	@Override 
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa(null, "Joao", "M", "joao@gmail.com", Instant.parse("2019-06-20T19:53:07Z"), "Brasileira", "0233001782");
		Pessoa p2 = new Pessoa(null, "Cristian", "M", "cristianrm@gmail.com", Instant.parse("2019-06-20T19:53:07Z"), "Brasileira", "0233001782");
		
		
		
		pessoaService.insert(p1);
		
		//PessoaRepository.saveAll(Arrays.asList(p1,p2));
		
		
		
//		Condominio con1 = new Condominio(null, "asa branca", "centro", "988889889", "99999999", "cristianrm@gmail.com");
//		Condominio con2 = new Condominio(null, "asa branca2", "centro", "988889889", "99999999", "cristianrm@gmail.com");
//		Condominio con3 = new Condominio(null, "asa branca3", "centro", "988889889", "99999999", "cristianrm@gmail.com");
//		Condominio con4 = new Condominio(null, "asa branca4", "centro", "988889889", "99999999", "cristianrm@gmail.com");
//		Condominio con5 = new Condominio(null, "asa branca5", "centro", "988889889", "99999999", "cristianrm@gmail.com");
//		
//		condominioRepository.saveAll(Arrays.asList(con1,con2,con3,con4,con5));
//		
//		Clientes c1 = new Clientes(null, "Joao1", true, "Rua 4", "Cajuru", "casa 1", "889898989", "Curitiba", "27/11/1988", "M", "999999999", "9999999999", "rrroiroeiroe@gmail.coom", "11/11/2019", "333333", "1111111111112",null, null, con1,null);
//		Clientes c2 = new Clientes(null, "Joao2", true, "Rua 5", "Cajuru", "casa 1", "889898989", "Curitiba", "27/11/1988", "M", "999999999", "9999999999", "rrroiroeiroe@gmail.coom", "11/11/2019", "333333", "1111111111112",null, null, con2,null);
//		Clientes c3 = new Clientes(null, "Joao3", true, "Rua 6", "Cajuru", "casa 1", "889898989", "Curitiba", "27/11/1988", "M", "999999999", "9999999999", "rrroiroeiroe@gmail.coom", "11/11/2019", "333333", "1111111111112",null, null, con3,null);
//				
//		clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
	}

}
