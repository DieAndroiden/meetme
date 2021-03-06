package de.dhbw.meetme.database.dao;

import de.dhbw.meetme.domain.Friendship;
import de.dhbw.meetme.domain.User;
import de.dhbw.meetme.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Data Access Object for User
 * <p>
 * This class is responsible to do the CRUD (create, read, update, delete) operations
 * for user objects in the database.
 * <p>
 * There is an alternative implementation UserClassicDao using the traditional way.
 * <p>
 * Decide yourself which one you want to use.
 * You may even mix both approaches.
 */
@ApplicationScoped
public class FriendshipDao extends JpaDao<UuidId, Friendship> {
    public FriendshipDao() {
        super(Friendship.class);
    }

    @SuppressWarnings("unchecked")
    public Collection<Friendship> findByName(String name) {
        Query query = entityManager.createQuery("select u from Friendship u where u.username1 = :name");
        query.setParameter("name", name);
        return (Collection<Friendship>) query.getResultList();
    }
    /*public Collection<User> findByEmail(String email) {
        Query query = entityManager.createQuery("select u from User u where u.email = :email");
        query.setParameter("email", email);
        return (Collection<User>) query.getResultList();
    }
    public User findByUserName(String name) {
        Query query = entityManager.createQuery("SELECT u from Friendship u where u.name = :name"); //prev.: from User u where u.username = :username"
        query.setParameter("name", name);
        return (User) query.getResultList().get(0);
    }*/
}
