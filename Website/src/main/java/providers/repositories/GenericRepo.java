package providers.repositories;

import managers.DatabaseManager;
import net.jodah.typetools.TypeResolver;

import java.util.List;

public class GenericRepo<T, ID> {
    protected Class<T> persistentClass;
    protected Class<ID> idClass;

    public GenericRepo() {
        Class<?>[] typeArguments = TypeResolver.resolveRawArguments(GenericRepo.class, getClass());
        this.persistentClass = (Class<T>) typeArguments[0];
        this.idClass = (Class<ID>) typeArguments[1];
    }

    public void create(T obj) {
        DatabaseManager.getInstance().runTransaction(session -> session.persist(obj));
    }

    public T read(ID id) {
        return DatabaseManager.getInstance().runTransactionWithRet(session -> session.find(persistentClass, id));
    }

    public List<T> readAll() {
        return DatabaseManager.getInstance().runTransactionWithRet(session -> (List<T>) session.createQuery("from " + persistentClass.getSimpleName()).list());
    }

    public T update(T obj) {
        return DatabaseManager.getInstance().runTransactionWithRet(session -> (T) session.merge(obj));
    }

    public void delete(T obj) {
        DatabaseManager.getInstance().runTransaction(session -> session.remove(obj));
    }
}
