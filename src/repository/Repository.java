package repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAllEntity();

    String getRepoId();

    T getEntityById(int id);

    void deleteEntityById(int id);

    void saveEntity(T entity);
}
