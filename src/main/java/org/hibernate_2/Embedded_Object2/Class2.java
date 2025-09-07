package org.hibernate_2.Embedded_Object2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Class2 {
    public static void main(String[] args) throws Exception{

        // Create embedded object
        FullName fname = new FullName();
        fname.setfName("Nikhat");
        fname.setmName("aka");
        fname.setlName("Parvin");

        // Create entity object
        College stud = new College();
        stud.setiD(102);
        stud.setColor("blue");
        stud.setFname(fname); // will create 3 extra columns in same table

        // Hibernate setup
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(College.class)
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Save entity
        session.persist(stud);

        tx.commit();
        session.close();
        factory.close();

        System.out.println(stud);
    }
}
