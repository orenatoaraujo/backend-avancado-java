package br.inf.ufg.bea.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.inf.ufg.bea.model.ContatoTO;

@CrossOrigin
@RepositoryRestResource(path="contatos", itemResourceRel="contato", collectionResourceRel="contatos")
public interface ContatoRepository extends CrudRepository<ContatoTO, Long> {

	List<ContatoTO> findByCpf(@Param("cpf")String cpf);

}