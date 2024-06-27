package br.pet.infraestrutura;


import br.pet.infraestrutura.dao.DaoManagerHiber;
import br.pet.infraestrutura.interfaces.InterfaceUsuario;
import br.pet.negocio.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

public class RepositorioUsuario implements InterfaceUsuario {

    @Override
    public void adicionar(Usuario obj) {
        List<Usuario> lista = recuperarPeloNome(obj);
        if (lista.isEmpty()) {
            DaoManagerHiber.persist(obj);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", "Adicionado com sucesso!");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", "Usuário já cadastrado no sistema!");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        }
    }

    @Override
    public void alterar(Usuario obj) {
        DaoManagerHiber.update(obj);
    }

    @Override
    public void deletar(Usuario obj) {
        DaoManagerHiber.delete(obj);
    }

    @Override
    public Usuario recupera(int codigo) {
        return (Usuario) DaoManagerHiber.recover("from Usuario where CODIGO=" + codigo);
    }

    @Override
    public List<Usuario> recuperaTudo() {
        return (List<Usuario>) DaoManagerHiber.recover("from Usuario");
    }

    private List<Usuario> recuperarPeloNome(Usuario usuario) {
        return DaoManagerHiber.recover("from Usuario where USUARIO='" + usuario.getUserNome() + "'");
    }

    @Override
    public Usuario validarUsuario(Usuario usuario) {
        List<Usuario> lista = recuperarPeloNome(usuario);
        
        if (lista.isEmpty()) {
            usuario = null;
            System.out.println("Usuario invalido!");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", " Usuário não encontrado!");
            RequestContext.getCurrentInstance().showMessageInDialog(message);

            return usuario;
        } else {
            if (lista.get(0).getUserSenha().trim().equals(usuario.getUserSenha().trim())) { 
                return lista.get(0);
            } else {
                usuario = null;
                System.out.println("Senha invalida!");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario", " Senha Invalida!");
                RequestContext.getCurrentInstance().showMessageInDialog(message);
                
                return usuario;
            }
        }
    }

}
