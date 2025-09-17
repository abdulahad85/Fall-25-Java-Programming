public class StudentTest{
 public static void main(String args[]){

     Date d= new Date(12,12,2006);
    
     Student s1=new Student("Abdul Ahad","Male",d,"786 CA");
     Student s2=new Student("Abdul Ahad","Male",d,"786 Fr");
     Student s3=new Student("Ali","Male",d,"567 Fr");
      
      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s3);
    
      s3.setAddress("378 LHR");

    System.out.println("After Updating.");
     
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