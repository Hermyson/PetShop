package br.pet.infraestrutura;

import br.pet.infraestrutura.dao.DaoManagerHiber;
import br.pet.infraestrutura.interfaces.InterfaceRepositorioGenerica;
import br.pet.negocio.Endereco;
import java.util.List;

/**
 *
 * @author Hermyson
 */
public class RepositorioEndereco implements InterfaceRepositorioGenerica<Endereco> {

    @Override
    public void adicionar(Endereco t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public Endereco recuperar(int c) {
        return (Endereco) (DaoManagerHiber.recover(c));
    }

    @Override
    public void alterar(Endereco t) {
        DaoManagerHiber.update(t);
    }

    @Override
    public void deletar(Endereco t) {
        DaoManagerHiber.delete(t);
    }

    @Override
    public List<Endereco> recuperarTodos() {
        return DaoManagerHiber.recover("from Endereco");
    }

   

}
