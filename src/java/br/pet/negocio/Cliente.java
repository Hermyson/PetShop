/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pet.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CollectionOfElements;

/**
 *
 * @author Hermyson
 */
@Entity
@Table(name = "Cliente")
@ManagedBean(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "codigo_Cliente")
    private int codigo_Cliente;
    @Column(length = 255, name = "nome")
    private String nome;
    @Column(length = 20, name = "telefone")
    private String telefone;
    @Column(length = 20, name = "telefone_Celular")
    private String telefoneCelular;
    @Embedded
    private Endereco endereco;

    @OneToMany
    @CollectionOfElements
    @Column(name = "Animais")
    private Collection<Animal> animais;
    
    @Column(length = 200, name = "email")
    private String email;

    //Método construtor
    public Cliente() {
        this.animais = new ArrayList<Animal>();
        this.endereco = new Endereco();

    }

    public int getCodigo_Cliente() {
        return codigo_Cliente;
    }

    public void setCodigo_Cliente(int codigo_Cliente) {
        this.codigo_Cliente = codigo_Cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Collection<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(Collection<Animal> animais) {
        this.animais = animais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
