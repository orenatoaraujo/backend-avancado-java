package br.inf.ufg.bea;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.inf.ufg.bea.enuns.EContato;
import br.inf.ufg.bea.model.ContatoTO;
import br.inf.ufg.bea.repository.ContatoRepository;

@SpringBootApplication
public class BeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ContatoRepository contatoRepository) {
        return args -> {
        	List<ContatoTO> contatos = contatoRepository.findByCpf("24871317056");
            if (contatos == null || contatos.isEmpty()) {
                initContatos(contatoRepository);
            }
        };
    }

    private void initContatos(ContatoRepository contatoRepository) {
        ContatoTO c1 = new ContatoTO();
        c1.setCpf("24871317056");
        c1.setDescricao("(62) 9999-8877");
        c1.setTipo(EContato.CELULAR);
        contatoRepository.save(c1);

        ContatoTO c2 = new ContatoTO();
        c2.setCpf("24871317056");
        c2.setDescricao("(62) 2222-3344");
        c2.setTipo(EContato.TELEFONE);
        contatoRepository.save(c2);

        ContatoTO c3 = new ContatoTO();
        c3.setCpf("24871317056");
        c3.setDescricao("fake@mail.com");
        c3.setTipo(EContato.EMAIL);
        contatoRepository.save(c3);

        ContatoTO c4 = new ContatoTO();
        c4.setCpf("69083026019");
        c4.setDescricao("bob@mail.com");
        c4.setTipo(EContato.EMAIL);
        contatoRepository.save(c4);

    }

}
