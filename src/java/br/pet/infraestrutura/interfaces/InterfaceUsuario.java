package br.pet.infraestrutura.interfaces;


import br.pet.negocio.Usuario;
import java.util.List;

public interface InterfaceUsuario {

    public void adicionar(Usuario obj);

    public void alterar(Usuario obj);

    public void deletar(Usuario obj);

    public Usuario recupera(int codigo);

    public List<Usuario> recuperaTudo();
    
    public Usuario validarUsuario(Usuario usuario);

}
