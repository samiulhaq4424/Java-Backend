package org.hibernate_2.MappingRelations3.OneToOne;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity   // ✅ creates Laptop table
class Laptop {
    @Id    // primary key
    private int Lid;
    private String lname;

    public void setId(int Lid) {
        this.Lid = Lid;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + Lid +
                ", lname=" + lname +
                '}';
    }
}
