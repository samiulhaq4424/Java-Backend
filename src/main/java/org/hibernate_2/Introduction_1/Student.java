package org.hibernate_2.Introduction_1;

import jakarta.persistence.*;

@Entity                             // Marks this class as a Hibernate entity (mapped to DB table)
@Table(name="student_table")        // Maps to "student_table" instead of default "Student"
class Student {

    @Id                             // Primary key
    private int iD;

    private String sname;           // Will be stored as column "sname"

    @Transient                      // This field will NOT be stored in DB
    private String color;

    // Getter & Setter methods
    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
