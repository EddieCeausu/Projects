// ****************************************************************
//   ManageAccounts.java
//
//   Use Account class to create and manage Sally and Joe's
//   bank accounts
// ****************************************************************

public class ManageAccounts
{
  public static void main(String[] args) {
  	Account acct1, acct2;

  	//create account1 for Sally with $1000
  	acct1 = new Account(1000, "Sally", 1111);
    System.out.println("Account Creation for Sally: " + acct1);
    acct2 = new Account(500, "Joe", 1112);
    System.out.println("Account Creation for Joe: " + acct2);
    System.out.println("Depositing $100 into Joe's acct");
    acct2.deposit(100);
    System.out.println("New Balance: " +  acct2.getBalance());
    System.out.println("Withdrawing $50 from Sally's acct");
    acct1.withdraw(50);
    System.out.println("New Balance: " + acct1.getBalance());
  	acct1.chargeFee();
    acct2.chargeFee();
    acct2.changeName("Joseph");
    System.out.println("Acount 1111 & Account 1112 Monthly Fee Charged\nAccount 1111 Name Change: Joseph");
    System.out.println(acct1 + "\n" + acct2);

    }
}
