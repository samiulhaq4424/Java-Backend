package org.hibernate_2.MappingRelations3.ManyToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;


@Entity   // ✅ creates Laptop table
class Laptop {
    @Id    // primary key
    private int Lid;
    private String lname;

    @ManyToMany
    private List<Student> stud = new ArrayList<>();

    public void setId(int Lid) {
        this.Lid = Lid;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setStud(List<Student> stud) {
        this.stud = stud;
    }

    public List<Student> getStud() {
        return stud;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + Lid +
                ", lname=" + lname +
                '}';
    }
}