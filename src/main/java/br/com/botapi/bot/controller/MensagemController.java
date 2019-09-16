package br.com.botapi.bot.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.botapi.bot.dto.MensagemDto;
import br.com.botapi.bot.entity.Mensagem;
import br.com.botapi.bot.form.MensagemForm;
import br.com.botapi.bot.repository.MensagemRepository;

@RestController
@RequestMapping("/messages")
public class MensagemController {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	@GetMapping
	public List<MensagemDto> listarMessage(){
		List<Mensagem> mensagem = mensagemRepository.findAll();
		
		return MensagemDto.convert(mensagem);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MensagemDto> listarMensagemId(@PathVariable Long id){
		Optional<Mensagem> mensagem = mensagemRepository.findById(id);
		if(mensagem.isPresent()) {
			return ResponseEntity.ok(new MensagemDto(mensagem.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<MensagemDto> cadastrarMensagem(@RequestBody @Valid MensagemForm mensagemForm, UriComponentsBuilder uriBuilder){
		Mensagem mensagem = mensagemForm.convert();
		mensagemRepository.save(mensagem);
		
		URI uri = uriBuilder.path("/messages/{id}").buildAndExpand(mensagem.getIdMessage()).toUri();
		return ResponseEntity.created(uri).body(new MensagemDto(mensagem));
	}

}
