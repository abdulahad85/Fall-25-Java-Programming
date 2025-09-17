public class StudentTest{
 public static void main(String args[]){

     Student s1=new Student("Abdul Ahad","Male","8 Aug 2006","786 CA");
     Student s2=new Student("Abdul Ahad","Male","4 Sep 2004","786 Fr");
     Student s3=new Student("Ali","Male","5 March 1998","567 Fr");
       
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