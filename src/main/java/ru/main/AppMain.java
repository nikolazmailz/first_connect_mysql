package ru.main;

import org.hibernate.Session;
import ru.firstConnectDb.ContactEntity;
import ru.utils.HibernateSessionFactory;

/**
 * Created by nikk on 22.08.2017.
 */
public class AppMain {

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setBirthDate(new java.util.Date());
        contactEntity.setFirstName("Nick");
        contactEntity.setLastName("VN");

        session.save(contactEntity);
        session.getTransaction().commit();

        session.close();


    }

}
