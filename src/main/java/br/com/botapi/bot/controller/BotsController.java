package br.com.botapi.bot.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.botapi.bot.dto.BotsDto;
import br.com.botapi.bot.entity.Bots;
import br.com.botapi.bot.form.AtualizarBotsForm;
import br.com.botapi.bot.form.BotsForm;
import br.com.botapi.bot.repository.BotsRepository;

@RestController
@RequestMapping("/bots")
public class BotsController {
	
	@Autowired
	private BotsRepository botsRepository;
	
	@GetMapping
	public List<BotsDto> listaBots(){
		List<Bots> bots = botsRepository.findAll();
		
		return BotsDto.convert(bots);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<BotsDto> cadastrarBots(@RequestBody @Valid BotsForm botsForm, UriComponentsBuilder uriBuilder){
		Bots bots = botsForm.convert();
		botsRepository.save(bots);
		
		URI uri = uriBuilder.path("/bots/{id}").buildAndExpand(bots.getIdBost()).toUri();
		return ResponseEntity.created(uri).body(new BotsDto(bots));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<BotsDto> atualizarBots(@PathVariable Long id, @RequestBody @Valid AtualizarBotsForm atualizarBotsForm){
		Optional<Bots> botsId = botsRepository.findById(id);
		if(botsId.isPresent()) {
			Bots bots = atualizarBotsForm.atualizar(id, botsRepository);
			return ResponseEntity.ok(new BotsDto(bots));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerBots(@PathVariable Long id){
		Optional<Bots> botsId = botsRepository.findById(id);
		if(botsId.isPresent()) {
			botsRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
