//***********************************************************
// TestAccounts1
// A simple program to test the numAccts method of the
// Account class.
//***********************************************************
import java.util.Scanner;

public class TestAccount {
  public static Scanner scan = new Scanner(System.in);
  public static Object input = 0;

  public static Account Consolodate(Account n1, Account n2) {
    if( !(n1.getName().equals(n2.getName())) ) {
      System.out.println("Accounts cannot be Consolodated");
      return null;
    } else if (n1.getAccountNum() == n2.getAccountNum()) {
      System.out.println("Accounts cannot be Consolodated");
      return null;
    }

    int balance = n1.getBalance() + n2.getBalance();
    String name = n1.getName() + " " + n2.getName();
    n1.close(); n2.close();

    return new Account(balance, name);
  }

  public static Account createAccount() {
    System.out.println("Enter Your Name: ");
    input = scan.next();
    return new Account(0, input);
  }

  public static void menu() {
    System.out.println("\tAccount Menu");
    System.out.println("Create New Account\t1");
    System.out.println("View Account\t2");
    System.out.println("Access Accounts\t3");
    input = scan.nextInt();
    if(input == 1) createAccount();
    if(input == 2) Account.getAccounts();
    //if(input == 3)
  }
  public static void main(String[] args) {
    	Account testAcct;

    	System.out.println("How many accounts would you like to create?");
    	int num = scan.nextInt();
    	for (int i=1; i<=num; i++) {
    		testAcct = new Account(100, "Name" + i);
    		System.out.println("\nCreated account " + testAcct);
    		System.out.println("Now there are " + Account.getAccounts() +
    				   " accounts");
    	    }

        }
}
