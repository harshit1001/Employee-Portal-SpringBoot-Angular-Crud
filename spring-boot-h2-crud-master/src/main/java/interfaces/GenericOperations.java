package interfaces;

import java.util.List;

public interface GenericOperations<E> {

 
    public E post(E entity);

    public List<E> get();

    public int put(E entity);

    public int delete(int id);
}
