/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pet.controller;

import br.pet.infraestrutura.interfaces.InterfaceRepositorioGenerica;
import br.pet.negocio.Endereco;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Hermyson
 */
@ManagedBean(name = "controladorEndereco")
@SessionScoped
public class ControllerEndereco {
    
      private br.pet.infraestrutura.interfaces.InterfaceRepositorioGenerica<Endereco> re = null;

    public ControllerEndereco() {
        this.re = (InterfaceRepositorioGenerica<Endereco>) new br.pet.infraestrutura.RepositorioEndereco();


    }

    public void adicionar(Endereco s) {
        this.re.adicionar(s);

    }

    public Endereco recuperar(int codigo) {
        return this.re.recuperar(codigo);


    }

    public void alterar(Endereco s) {
        this.re.alterar(s);

    }

    public void deletar(Endereco s) {
        this.re.deletar(s);

    }

    public List<Endereco> recuperarTodos() {
        return this.re.recuperarTodos();

    }
}
