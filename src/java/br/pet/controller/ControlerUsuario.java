package br.pet.controller;

import br.pet.infraestrutura.RepositorioUsuario;
import br.pet.infraestrutura.interfaces.InterfaceUsuario;
import br.pet.negocio.Usuario;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "usuarioCont")
@SessionScoped
public class ControlerUsuario {

    private InterfaceUsuario ru = null;
    private Usuario usuario;
    private FacesMessage mensagem = null;
    
    public ControlerUsuario() {
        this.usuario = null;
        this.ru = new RepositorioUsuario();
    }

    public void adicionar(Usuario obj) {
        this.ru.adicionar(obj);
    }

    public void alterar(Usuario obj) {
        this.ru.alterar(obj);
    }

    public void deletar(Usuario obj) {
        this.ru.deletar(obj);
    }

    public Usuario recupera(int codigo) {
        return this.ru.recupera(codigo);
    }

    public List<Usuario> recuperaTudo() {
        return this.ru.recuperaTudo();
    }

    public void validarUsuario(Usuario usuario) {
        if (usuario.getUserNome().trim().isEmpty()) {
            this.mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", "Você deve informa o nome de usuário de acesso!");
            RequestContext.getCurrentInstance().showMessageInDialog(mensagem);
        } else if (usuario.getUserSenha().trim().isEmpty()) {
            this.mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", "Você deve informa a senha de acesso!");
            RequestContext.getCurrentInstance().showMessageInDialog(mensagem);
        } else {
            this.usuario = this.ru.validarUsuario(usuario);
            if (this.usuario != null) {
                if (this.usuario.getPerfil().trim().equals("administrador")) {
                    redirecionar("administrador");
                } else if (this.usuario.getPerfil().trim().equals("professor")) {
                    redirecionar("professor");
                } else {
                    redirecionar("aluno");
                }
                this.mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", "Bem vindo! " + this.usuario.getPerfil() + ", " + this.usuario.getUserNome());
                RequestContext.getCurrentInstance().showMessageInDialog(mensagem);
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("menuGeral.xhtml");
                } catch (IOException ex) {
                    RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", ex.getMessage()));
                }
            }
        }
    }

    public String redirecionar(String url) {
        return url + "xhtml";
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
