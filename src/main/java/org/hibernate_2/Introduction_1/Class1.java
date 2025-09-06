package org.hibernate_2.Introduction_1;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Main class to run Hibernate
class Class1 {

    public static void main(String[] args) throws Exception{

        // Create a new Student object
        Student s1 = new Student();
        s1.setiD(104);          // setting primary key
        s1.setSname("Sam");     // setting student name
        s1.setColor("Green");   // this field is @Transient, so it won’t be stored in DB

        // Step 1: Load configuration from hibernate.cfg.xml + add annotated class
        Configuration config = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure();

        // Step 2: Build SessionFactory (heavyweight object, usually one per app)
        SessionFactory factory = config.buildSessionFactory();

        // Step 3: Open Session (represents a connection with DB)
        Session session = factory.openSession();

        // Step 4: Begin transaction (all DB operations must be inside a transaction)
        Transaction transaction = session.beginTransaction();

        // Step 5: Persist (save) student object in DB
        session.persist(s1);

        // Step 6: Commit transaction to apply changes
        transaction.commit();

        // Step 7: Close session and factory
        session.close();
        factory.close();
    }
}
