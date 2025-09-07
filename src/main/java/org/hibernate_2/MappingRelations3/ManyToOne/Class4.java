package org.hibernate_2.MappingRelations3.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Class4 {
    public static void main(String[] args) {

        // Create Laptop
        Laptop laptop = new Laptop();
        laptop.setId(101);
        laptop.setLname("Hp");

        // Create Student
        Student s1 = new Student();
        s1.setRollNo(1);
        s1.setName("Samiul");
        s1.setMarks(91);

        // ✅ Must set both sides of relation
        laptop.setStud(s1);        // owning side (FK column lives here)
        s1.getLap().add(laptop);   // inverse side (only for navigation)

        // Hibernate setup
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Save entities
        session.persist(laptop);
        session.persist(s1);

        tx.commit();
        session.close();
        factory.close();
    }
}
