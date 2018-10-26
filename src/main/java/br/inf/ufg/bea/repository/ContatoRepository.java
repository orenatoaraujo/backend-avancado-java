package br.inf.ufg.bea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.inf.ufg.bea.model.ContatoTO;

@CrossOrigin
@RepositoryRestResource(path="/contatos")
public interface ContatoRepository extends CrudRepository<ContatoTO, Long> {

    ContatoTO findByCpf(String cpf);

}