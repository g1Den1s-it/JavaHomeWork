package org.example.Lab_6.lab_7;
import org.example.Lab_6.Entities.Adress;
import org.example.Lab_6.Entities.Event;
import org.example.Lab_6.Entities.Guests;
import org.example.Lab_6.Entities.SocialMedia;
import org.hibernate.Session;

import java.util.Arrays;

import static org.example.Lab_6.HibernateUtil.getSessionFactory;

public class HubernateMain7 {
//    Implement OneToOne, OneToMany, ManyToMany relations in your models from previous task. (add some additional tables if need)
//    Test it by CRUD.

    public static void main(String[] args) {
        Event event = new Event("Night party", "2024-01-01");
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();

        //OneToOne
        event.setAdress(new Adress("vylytsya holovna"));
        Long id = (Long) session.save(event);
        System.out.println("OneToOne: " + session.get(Event.class, id));

        //OneToMany
        event.setGuests(Arrays.asList(new Guests("David"), new Guests("Den"), new Guests("Jon")));
        session.saveOrUpdate(event);
        System.out.println("OneToMany: " + session.get(Event.class, id));

        //ManyToMany
        Event event2 = new Event("Party", "2024-05-04");
        SocialMedia facebook = new SocialMedia("Facebook");
        SocialMedia telegram = new SocialMedia("Telegram");

        Long id2 = (Long) session.save(event2);

        session.save(facebook);
        session.save(telegram);


        event.setSocialMedia(Arrays.asList(facebook, telegram));
        event2.setSocialMedia(Arrays.asList(telegram));

        session.saveOrUpdate(event);
        session.saveOrUpdate(event2);

        System.out.println("ManyToMany: " + session.get(Event.class, id));
        System.out.println("ManyToMany: " + session.get(Event.class, id2));

        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }
}
