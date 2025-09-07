package org.hibernate_2.MappingRelations3.ManyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity   // ✅ Student table
class Student {

    @Id
    private int rollNo;
    private String name;
    private int marks;

    @OneToMany(mappedBy = "stud") // ✅ inverse side → "stud" is FK owner
    private List<Laptop> lap = new ArrayList<>();

    public void setRollNo(int rollNo) { this.rollNo = rollNo; }
    public void setName(String name) { this.name = name; }
    public void setMarks(int marks) { this.marks = marks; }

    public List<Laptop> getLap() { return lap; }
    public void setLap(List<Laptop> lap) { this.lap = lap; }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name=" + name +
                ", marks=" + marks +
                '}';
    }
}
