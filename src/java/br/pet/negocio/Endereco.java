/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pet.negocio;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;

import javax.persistence.Embeddable;

/**
 *
 * @author Hermyson
 */
@Embeddable
@ManagedBean(name = "endereco")
public class Endereco implements Serializable {


    @Column(length = 255, name = "logradouro")
    private String logradouro;
    @Column(length = 10, name = "numero")
    private String numero;
    @Column(length = 255, name = "complemento")
    private String complemento;
    @Column(length = 255, name = "bairro")
    private String bairro;
    @Column(length = 255, name = "cidade")
    private String cidade;
    @Column(length = 2, name = "uf")
    private String uf;
    @Column(length = 15, name = "cep")
    private String cep;
    

    public Endereco() {
        
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
