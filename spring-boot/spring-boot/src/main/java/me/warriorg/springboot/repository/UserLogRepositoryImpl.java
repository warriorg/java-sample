package me.warriorg.springboot.repository;

import me.warriorg.springboot.model.User;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class UserLogRepositoryImpl extends SimpleJpaRepository<User, String> implements UserRepository {

    private final EntityManager entityManager;
    /**
     * Creates a new {@link SimpleJpaRepository} to manage objects of the given {@link JpaEntityInformation}.
     *
     * @param entityInformation must not be {@literal null}.
     * @param entityManager     must not be {@literal null}.
     */
    public UserLogRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public void test() {
        this.entityManager.createNativeQuery("").getResultList();
    }
}
