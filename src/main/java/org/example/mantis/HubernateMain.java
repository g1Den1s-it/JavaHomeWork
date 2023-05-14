package org.example.mantis;

import org.example.Lab_6.Entities.Event;
import org.example.mantis.entities.MantisUser;
import org.hibernate.Session;

import javax.persistence.Query;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static org.example.mantis.HibernateUtil.getSessionFactory;


public class HubernateMain {
//    Make at least two tables (Entities from previous task or any additional if need)
//    Make models for those Entities (from Task_5)
//    Setup Hibernate for those Entities and local DB
//    Check basic CRUD (create, read, update, delete the BD records using Hibernate)
//    Generate few rows into all tabled
    static Session session = getSessionFactory().getCurrentSession();
    static Integer REPORTER_LEVEL=25;
    static Integer ADMIN_LEVEL=90;
    static Integer DEV_LEVEL=55;
    public static void main(String[] args) throws NoSuchAlgorithmException {

        session.beginTransaction();

        CreatorUser creatorUser = new CreatorUser();

        session.save(creatorUser.getUser(REPORTER_LEVEL));
        session.save(creatorUser.getUser(REPORTER_LEVEL));
        session.save(creatorUser.getUser(REPORTER_LEVEL));

        session.save(creatorUser.getUser(DEV_LEVEL));
        session.save(creatorUser.getUser(DEV_LEVEL));
        session.save(creatorUser.getUser(DEV_LEVEL));

        printAllUsers();
        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }
    private static void printAllUsers() {

        Query query = session.createQuery("FROM "+MantisUser.class.getName());
        List<MantisUser> results = query.getResultList();
        results.forEach(mu->{
            System.out.println(mu.getUsername()+"\troot\t"+mu.getAccessLevel());
        });
        System.out.println("results "+results);
    }
}
