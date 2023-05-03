package org.example.Lab_6;

import org.example.Lab_6.Entities.Event;
import org.hibernate.Session;

import static org.example.Lab_6.HibernateUtil.getSessionFactory;

public class HubernateMain {
//    Make at least two tables (Entities from previous task or any additional if need)
//    Make models for those Entities (from Task_5)
//    Setup Hibernate for those Entities and local DB
//    Check basic CRUD (create, read, update, delete the BD records using Hibernate)
//    Generate few rows into all tabled

    public static void main(String[] args) {
        Event event = new Event("Path", "2023-11-11");
        Event d2 = new Event("Night Party", "2024-02-12");
        Session session = getSessionFactory().getCurrentSession();

        session.beginTransaction();
        //create
        Long id = (Long) session.save(event);
        session.save(d2);
        System.out.println("id: "+ id);

        //read
        Event dateRead = session.get(Event.class, id);
        System.out.println(dateRead);

        //update
        dateRead.setEvent("Party");
        session.saveOrUpdate(dateRead);

        //delete
        session.delete(dateRead);

        session.getTransaction().commit();

        session.close();
        System.exit(0);
    }
}
