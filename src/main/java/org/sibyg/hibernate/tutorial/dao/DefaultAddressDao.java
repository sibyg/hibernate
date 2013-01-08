package org.sibyg.hibernate.tutorial.dao;

import org.apache.commons.lang.NotImplementedException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sibyg.hibernate.tutorial.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultAddressDao implements  AddressDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public DefaultAddressDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Address address) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.save(address);
        currentSession.getTransaction().commit();
    }

    public void delete(Long id) {
        throw new NotImplementedException();
    }

    public void get(Long id) {
        throw new NotImplementedException();
    }

    public void update(Address address) {
        throw new NotImplementedException();
    }
}
