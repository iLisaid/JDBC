package DAO;

import java.util.List;

public interface AbstractController <E, K>{
    List<E> getAll();
    E getEntityById(K id);
    boolean update(E entity);
    boolean delete(K id);
    boolean create(E entity);
}
