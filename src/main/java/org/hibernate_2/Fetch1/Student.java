package org.hibernate_2.Fetch1;

import jakarta.persistence.*;

@Entity                             // Marks this class as a Hibernate entity (mapped to DB table)
@Table(name="student")  // ✅ maps to your "student" table in database
class Student {

    @Id                             // Primary key
    private int iD;

    private String sname;           // Will be stored as column "sname"

//    @Transient     //if used, Hibernate will IGNORE this field (not saved in DB)
    private String color;


    public void setiD(int iD) {
        this.iD = iD;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Student[" + "iD=" + iD + ", sname=" + sname + ", color=" + color + ']';
    }
}
