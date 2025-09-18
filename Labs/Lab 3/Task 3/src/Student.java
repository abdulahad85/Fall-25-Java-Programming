public class Student {
    private String id;
    private String name;
    private String gender;
    private Date dob;
    private Address address;
    static int count;

   
    Student() {
         count++;

        this.id = String.format("SP25-BCS-%03d", count);
    }

    
    Student(String name, String gender, Date dob, Address address) {
        count++;
        this.id = String.format("SP25-BCS-%03d", count);
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
    }

    
    Student(Student s) {
        count++;
        this.id = String.format("SP25-BCS-%03d", count); 
        this.name = s.name;
        this.gender = s.gender;
        this.dob = s.dob;
        this.address = s.address;
    }

   
    public void setName(String name) { 
        this.name = name; 
 }
    public String getName() {
        return name;
 }

    public void setGender(String gender) { 
      this.gender = gender; 
}
    public String getGender() { 
      return gender; 
}

    public void setDob(Date dob) { 
      this.dob = dob; 
}
    public Date getDob() { 
      return dob; 
}

    public void setAddress(Address address) { 
     this.address = address; 
}
    public Address getAddress() {
     return address; 
}

    
    public String toString() {
        return String.format("%-15s %-15s %-15s %-15s %-15s", id, name, gender, dob, address);
    }

public boolean equals(Object o){
		//Student o=(Student)o;
		return this.name.equals(((Student)o).getName());
	}

 } 


