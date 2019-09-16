package br.com.botapi.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.botapi.bot.entity.Bots;

public interface BotsRepository extends JpaRepository<Bots, Long>{

}
