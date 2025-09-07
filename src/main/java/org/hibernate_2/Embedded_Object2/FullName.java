package org.hibernate_2.Embedded_Object2;


import jakarta.persistence.Embeddable;

             // ✅ Marks this class as a value object (not its own table).
@Embeddable // ✅ All its fields will be stored as columns inside the parent entity’s table.
public class FullName {

    private String fName;
    private String mName;
    private String lName;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "fName=" + fName +
                ", mName=" + mName +
                ", lName=" + lName +
                '}';
    }
}
