package org.hibernate_2.Embedded_Object2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "student1")   // mapped to student1 table
class College {

    @Id
    private int iD;
    private FullName fname; // ✅ @Embeddable → fields stored in same table
    private String color;


    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public FullName getFname() {
        return fname;
    }

    public void setFname(FullName fname) {
        this.fname = fname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "College{" +
                "iD=" + iD +
                ", fname=" + fname +
                ", color=" + color +  +
                '}';
    }
}
