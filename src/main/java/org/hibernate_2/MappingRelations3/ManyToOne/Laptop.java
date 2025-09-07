package org.hibernate_2.MappingRelations3.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity   // ✅ Laptop table
class Laptop {
    @Id
    private int Lid;
    private String lname;

    @ManyToOne   // ✅ Many laptops → One student
    private Student stud; // FK column will be here

    public void setId(int Lid) { this.Lid = Lid; }
    public void setLname(String lname) { this.lname = lname; }

    public void setStud(Student stud) {
        this.stud = stud;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + Lid +
                ", lname=" + lname +
                '}';
    }
}
