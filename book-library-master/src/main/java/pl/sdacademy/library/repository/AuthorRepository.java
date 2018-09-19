package pl.sdacademy.library.repository;

import pl.sdacademy.library.entity.Author;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AuthorRepository extends AbstractRepository<Author, Long> {

    @PersistenceContext(unitName = "sda")
    private EntityManager entityManager;

    @Override
    public Author findOne(Long primaryKey) {
        return entityManager.find(Author.class, primaryKey);
    }

    @Override
    public List<Author> findPage(int pageIndex, int pageSize) {
        return entityManager.createQuery("from Author", Author.class)
                .setFirstResult((pageIndex - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    @Override
    public List<Author> findAll() {
        return entityManager.createQuery("from Author", Author.class).getResultList();
    }

    @Override
    public Author save(Author entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void delete(Author entity) {
        entityManager.remove(entity);
    }

    @Override
    public Long count() {
        return entityManager.createQuery("select count(a) from Author a", Long.class).getSingleResult();
    }

    @Override
    public boolean exists(Long primaryKey) {
        return false;
    }
}
