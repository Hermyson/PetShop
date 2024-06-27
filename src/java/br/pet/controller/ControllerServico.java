package br.pet.controller;

import br.pet.infraestrutura.interfaces.InterfaceRepositorioGenerica;
import br.pet.negocio.Servico;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Hermyson
 */
@ManagedBean(name = "controladorServico")
@SessionScoped
public class ControllerServico {

    private br.pet.infraestrutura.interfaces.InterfaceRepositorioGenerica<Servico> rs = null;

    public ControllerServico() {
        this.rs = (InterfaceRepositorioGenerica<Servico>) new br.pet.infraestrutura.RepositorioServico();


    }

    public void adicionar(Servico s) {
        this.rs.adicionar(s);

    }

    public Servico recuperar(int codigo) {
        return this.rs.recuperar(codigo);


    }

    public void alterar(Servico s) {
        this.rs.alterar(s);

    }

    public void deletar(Servico s) {
        this.rs.deletar(s);

    }

    public List<Servico> recuperarTodos() {
        return this.rs.recuperarTodos();

    }
}
