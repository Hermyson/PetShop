
package br.pet.infraestrutura;

import br.pet.infraestrutura.dao.DaoManagerHiber;
import br.pet.infraestrutura.interfaces.InterfaceRepositorioGenerica;
import br.pet.negocio.Servico;
import java.util.List;

/**
 *
 * @author Hermyson
 */
public class RepositorioServico implements InterfaceRepositorioGenerica<Servico>{

     @Override
    public void adicionar(Servico t) {
         DaoManagerHiber.persist(t); 
    }

    @Override
    public Servico recuperar(int c) {
        return (Servico) (DaoManagerHiber.recover(c));
    }

    @Override
    public void alterar(Servico t) {
         DaoManagerHiber.update(t);
    }

    @Override
    public void deletar(Servico t) {
      DaoManagerHiber.delete(t);
    }

    @Override
    public List<Servico> recuperarTodos() {
      return DaoManagerHiber.recover("from Servico");
        
    }

    
    
}
