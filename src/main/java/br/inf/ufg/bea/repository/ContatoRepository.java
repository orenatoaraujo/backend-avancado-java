package br.inf.ufg.bea.repository;

import org.springframework.data.repository.CrudRepository;

import br.inf.ufg.bea.model.ContatoTO;

public interface ContatoRepository extends CrudRepository<ContatoTO, Long> {

}
