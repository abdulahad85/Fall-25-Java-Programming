// Abdul Ahad Shahid
// Sp25-Bcs-001

public class Student {

   
    private String name;
    private String email;
    private double gpa;

   
    public Student(String name, String email, double gpa) {
        this.name = name;
        this.email = email;
        this.gpa = gpa;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

   
    public double getGpa() {
        return gpa;
    }

   
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

   
    public void display() {
       
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("GPA: " + gpa);
    }
}
