// ****************************************************************
// DogTest.java
//
// A simple test class that creates a Dog and makes it speak.
//
// ****************************************************************

public class DogTest {
  public static void main(String[] args) {
    Dog lab = new Labrador("Bill", "black");
    Dog york = new Yorkshire("Jim");
    System.out.println("Yorkshire Name is: " + york.getName());
    System.out.println("Labrador Name is: " + lab.getName());
    System.out.println(lab.getName() + " says: " + lab.speak());
    System.out.println(york.getName() + " says: " + york.speak());
    System.out.println(lab.avgBreedWeight());
    System.out.println(york.avgBreedWeight());
  }
}
