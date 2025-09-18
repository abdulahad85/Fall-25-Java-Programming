public class StudentTest{
 public static void main(String args[]){

     Date d1= new Date(12,12,2006);
     Date d2= new Date(12,11,1990);
     Date d3= new Date(19,10,1999);


      
    Address a1=new Address("486","Block C", "Faisal Town","Lahore","Pakistan");
    Address a2=new Address("988","Block A", "Johar Town", "Lahore","Pakistan");
    Address a3=new Address("840","Block F", "Bahria Town","Lahore","Pakistan");


     Student s1=new Student("Abdul Ahad","Male",d1,a1);
     Student s2=new Student("Abdul Ahad","Male",d2,a2);
     Student s3=new Student("Ali","Male",d3,a3);
      
      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s3);
    
   

        System.out.println();


    
          if(s1.equals(s2))
		System.out.println("Objects are equal");
		if(s1.equals(s3))
		System.out.println("s1, and s3; Objects are equal");


     
}



}