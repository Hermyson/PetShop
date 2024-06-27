package br.pet.controller;

import br.pet.infraestrutura.RepositorioAnimal;
import br.pet.infraestrutura.interfaces.InterfaceRepositorioGenerica;
import br.pet.negocio.Animal;
import br.pet.negocio.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hermyson
 */
@ManagedBean(name = "controladorAnimal")
@SessionScoped
public class ControllerAnimal implements Serializable {

    private InterfaceRepositorioGenerica<Animal> ra = null;
    private Cliente cliente = null;
    private ControllerCliente controlerCliente = null;

    public ControllerAnimal() {
        this.cliente = new Cliente();
        this.controlerCliente = new ControllerCliente();
        this.ra = new RepositorioAnimal();
    }

    public void adicionar(Animal a) {
        //Recupera o cliente cadastrado no banco e seta o atributo SelectdC da Managebean (controladorCliente)
        this.controlerCliente = (ControllerCliente) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("controladorCliente");
        this.cliente = this.controlerCliente.getSelectedC();
        if (cliente == null) {
            System.out.println("null");
        } else {
            //Persiste o animal no BD
            this.ra.adicionar(a);
            //
            this.cliente.getAnimais().add(a);
            this.controlerCliente.alterarCliente(cliente);//Adicina o animal no cliente
        }

//        return "apresentarClienteCadastrado.xhtml";
    }

    public Animal recuperar(int codigo) {
        return this.ra.recuperar(codigo);

    }

    public void alterar(Animal a) {
        this.ra.alterar(a);

    }

    public void deletar(Animal a) {
        this.ra.deletar(a);

    }

    public List<Animal> recuperarTodos() {
        return this.ra.recuperarTodos();

    }
}
