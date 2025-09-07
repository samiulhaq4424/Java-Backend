package org.hibernate_2.MappingRelations3.OneToOne;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity   // ✅ creates Student table
class Student {

    @Id    // primary key
    private int rollNo;
    private String name;
    private int marks;

    @OneToOne    // ✅ one student ↔ one laptop
    private Laptop lap; // foreign key to Laptop


    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setLap(Laptop lap) {
        this.lap = lap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name=" + name +
                ", marks=" + marks +
                '}';
    }
}
