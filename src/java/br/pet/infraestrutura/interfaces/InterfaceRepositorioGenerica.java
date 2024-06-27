/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pet.infraestrutura.interfaces;

import br.pet.negocio.Cliente;
import java.util.List;

/**
 *
 * @author Hermyson
 */
public interface InterfaceRepositorioGenerica <T> {
    
    public void adicionar(T t);
    public T recuperar(int c);
    public void alterar(T t);
    public void deletar(T t);
    public List<T> recuperarTodos();

    
   

     
}