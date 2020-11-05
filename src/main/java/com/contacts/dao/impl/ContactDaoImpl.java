package com.contacts.dao.impl;

import com.contacts.dao.ContactDao;
import com.contacts.exception.DataProcessingException;
import com.contacts.model.Contact;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ContactDaoImpl implements ContactDao {
    private static final Logger log = Logger.getLogger(UserDaoImpl.class);
    private final SessionFactory sessionFactory;

    public ContactDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Contact add(Contact contact) {
        log.info("Trying to add the contact " + contact + " to the DB.");
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(contact);
            transaction.commit();
            log.info("Successfully added the contact " + contact + " to the DB.");
            return contact;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Failed to add the contact "
                    + contact + " to the DB.", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Contact> findByEmail(String email) {
        log.info("Trying to get the contact with the email " + email);
        try (Session session = sessionFactory.openSession()) {
            Query<Contact> query = session.createQuery("from Contact "
                    + "where email = :email", Contact.class);
            query.setParameter("email", email);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Failed to find a contact with the email "
                    + email, e);
        }
    }

    @Override
    public Optional<Contact> findById(Long id) {
        log.info("Trying to get the contact with the ID " + id);
        try (Session session = sessionFactory.openSession()) {
            return Optional.of(session.get(Contact.class, id));
        } catch (Exception e) {
            throw new DataProcessingException("Failed to find a contact with the ID "
                    + id, e);
        }
    }

    @Override
    public List<Contact> getAll() {
        log.info("Trying to get all contacts...");
        try (Session session = sessionFactory.openSession()) {
            Query<Contact> getAllContactsQuery = session.createQuery("from Contact", Contact.class);
            return getAllContactsQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Failed to get all contacts from the DB.", e);
        }
    }

    @Override
    public Contact update(Contact contact) {
        log.info("Trying to update the contact " + contact);
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(contact);
            transaction.commit();
            log.info("Successfully updated the contact " + contact);
            return contact;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Failed to update the contact "
                    + contact, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
