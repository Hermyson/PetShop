package br.pet.controller;

import br.pet.infraestrutura.RepositorioCliente;
import br.pet.infraestrutura.interfaces.InterfaceRepositorioGenerica;
import br.pet.negocio.Animal;

import br.pet.negocio.Cliente;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Hermyson
 */
@ManagedBean(name = "controladorCliente")
@SessionScoped
public class ControllerCliente {

    private InterfaceRepositorioGenerica<Cliente> rc = null;
    private Cliente SelectedC;
    private Animal SelectedAnimal;

    //Método construtor
    public ControllerCliente() {
        this.rc = new RepositorioCliente();
    }

    public void adicionarCliente(Cliente cliente) {        
        this.rc.adicionar(cliente);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente", "Cadastrado "+cliente.getNome());
            RequestContext.getCurrentInstance().showMessageInDialog(message);
//        ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("clicad", cliente);
//       return "CadastrarAnimal.xhtml";

    }

    public void alterarCliente(Cliente cliente) {
        this.rc.alterar(cliente);

    }

    public Cliente recuperarCliente(int codigo) {
        return this.rc.recuperar(codigo);
    }

    public void excluirCliente(Cliente cliente) {
        this.rc.deletar(cliente);

    }

    public List<Cliente> recuperaTodos() {
        return this.rc.recuperarTodos();
    }

    public String inicializaCadastroAnimal() {
        return "CadastrarAnimal.xhtml";
    }

    public Cliente getSelectedC() {
        return SelectedC;
    }

    public void setSelectedC(Cliente SelectedC) {
        this.SelectedC = SelectedC;
    }

    public Animal getSelectedAnimal() {
        return SelectedAnimal;
    }

    public void setSelectedAnimal(Animal SelectedAnimal) {
        this.SelectedAnimal = SelectedAnimal;
    }
}
