package br.pet.infraestrutura;

import br.pet.infraestrutura.dao.DaoManagerHiber;
import br.pet.infraestrutura.interfaces.InterfaceRepositorioGenerica;
import br.pet.negocio.Animal;
import java.util.List;

/**
 *
 * @author Hermyson
 */
public class RepositorioAnimal implements InterfaceRepositorioGenerica<Animal> {

    @Override
    public void adicionar(Animal t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public Animal recuperar(int c) {
        return (Animal) (DaoManagerHiber.recover(c));
    }

    @Override
    public void alterar(Animal t) {
        DaoManagerHiber.update(t);

    }

    @Override
    public void deletar(Animal t) {
        DaoManagerHiber.delete(t);
    }

    @Override
    public List<Animal> recuperarTodos() {
        return DaoManagerHiber.recover("from Animal");
    }

  

    
}
