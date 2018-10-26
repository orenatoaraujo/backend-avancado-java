package br.inf.ufg.bea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import br.inf.ufg.bea.enuns.EContato;

@SuppressWarnings("serial")
@Entity
public class ContatoTO extends Domain {

    @CNPJ
    @Length(min = 11, max = 11)
    @Column(name = "cpf", nullable = false, length = 11)
    private String   cpf;

    @Column(name = "descricao")
    private String   descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "contato_tipo")
    private EContato tipo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EContato getTipo() {
        return tipo;
    }

    public void setTipo(EContato tipo) {
        this.tipo = tipo;
    }

}
