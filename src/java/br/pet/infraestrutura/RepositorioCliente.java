/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pet.infraestrutura;

import br.pet.infraestrutura.dao.DaoManagerHiber;
import br.pet.infraestrutura.interfaces.InterfaceRepositorioGenerica;
import br.pet.negocio.Cliente;
import java.util.List;

/**
 *
 * @author Hermyson
 */
public class RepositorioCliente implements InterfaceRepositorioGenerica<Cliente> {

    @Override
    public void adicionar(Cliente t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public Cliente recuperar(int c) {
        return (Cliente) (DaoManagerHiber.recover(c));
    }

    @Override
    public void alterar(Cliente t) {
        DaoManagerHiber.update(t);
    }

    @Override
    public void deletar(Cliente t) {
        DaoManagerHiber.delete(t);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return DaoManagerHiber.recover("from Cliente");
    }

   
}
