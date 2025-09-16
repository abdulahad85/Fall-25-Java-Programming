// Abdul Ahad Shahid
// Sp25-Bcs-001

public class Employee{
  
private String name;
private int ssn;
private double baseSalary;
private String address;




   
  

       public Employee(String name, int ssn, double baseSalary ,String address) {
        this.name = name;
        this.ssn = ssn;
        this.baseSalary = baseSalary;
        this.address = address;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public int getSSN() {
        return ssn;
    }


    public void setSSN(int ssn) {
        this.ssn = ssn;
    }

   
    public double getBaseSalary() {
        return baseSalary;
    }

   
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
  
   
    public String getAddress() {
        return address;
    }

     //Setter is used for modify 

    public void setAddress(String address) {
        this.address = address;
    }
   
    public void display() {
       
        System.out.println("Name: " + name);
        System.out.println("SNN: " + ssn);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Address: " + address);

        
    }
}
