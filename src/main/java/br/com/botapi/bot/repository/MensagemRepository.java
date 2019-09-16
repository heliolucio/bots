package br.com.botapi.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.botapi.bot.entity.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

}
