package org.hibernate_2.Fetch1;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Main class to run Hibernate
class Class1 {

    public static void main(String[] args) throws Exception{

        // -------------------------------------------------------
        // Step 0: Create an object (entity) to be stored in DB
        // -------------------------------------------------------
        Student s1 = new Student();
        s1.setiD(106);          // Primary key
        s1.setSname("Dilip");   // Normal column
        s1.setColor("Blue");

        Student s2 = null;  // placeholder for fetched student

        // -------------------------------------------------------
        // Step 1: Build SessionFactory (heavy object → usually singleton)
        //  - Reads hibernate.cfg.xml
        //  - Loads mappings and DB configs
        // -------------------------------------------------------
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        // -------------------------------------------------------
        // Step 2: Open Session (like a connection to DB)
        // -------------------------------------------------------
        Session session = factory.openSession();

        // -------------------------------------------------------
        // Step 3: Begin Transaction
        //  - All Hibernate operations (insert, update, delete, select)
        //    should happen inside a transaction
        // -------------------------------------------------------
        Transaction tx = session.beginTransaction();

        // -------------------------------------------------------
        // Step 4: Persist object → INSERT into DB
        // -------------------------------------------------------
        session.persist(s1);

        // -------------------------------------------------------
        // Step 5: Fetch object by primary key
        //  - session.get() returns entity if found, else null
        // -------------------------------------------------------
        s2 = session.get(Student.class, 101);

        // -------------------------------------------------------
        // Step 6: Commit Transaction (apply changes to DB)
        // -------------------------------------------------------
        tx.commit();

        // -------------------------------------------------------
        // Step 7: Close Session + SessionFactory
        // -------------------------------------------------------
        session.close();
        factory.close();

        // -------------------------------------------------------
        // Step 8: Print result of fetch
        // -------------------------------------------------------
        if (s2 != null) {
            System.out.println(s2);
        } else {
            System.out.println("Student not found");
        }
    }
}
