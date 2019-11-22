package ua.edu.ucu;


public class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Student)) {
            return false;
        } else {
            Student other = (Student) obj;
            if (other.hashCode() != obj.hashCode()) {
                return false;
            }
            return other.GPA == GPA && year == other.year &&
                    name.equals(other.name) && surname.equals(other.surname);
        }
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname + ", "
                + "GPA=" + GPA + ", year=" + year + '}';
    }

}
