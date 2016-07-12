package lk.ac.pdn.co328.studentSystem;

public class Student {

    private int id;
    private String firstName;
    private String lastName;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }

        Student stud = (Student) obj;
        return stud.getId() == getId() && stud.getFirstName().equals(getFirstName()) && stud.getLastName().equals(getLastName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 83 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        return hash;
    }
}
