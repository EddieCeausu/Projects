import java.util.*;

public class Account {
  private int balance;
  private String name;
  private long accNumber;
  private static int numAccounts = 0;

  /**
  * Constructor
  * @param int
  * @param String
  * @return Account
  */
  public Account(int initBalance, String name) {
    this.balance = initBalance;
    this.name = name;
    accNumber = (long) Math.ceil(Math.random() * 1000000000);
    numAccounts ++;
  }
  /**
  * @param int
  */
  public void deposit(int n) {
    balance += n;
  }

  public void withdraw(int n) {
    if(n > balance) {
      System.out.print("Insufficent Funds");
      return;
    }

    balance -= n;
  }

  public static int getAccounts() {
    return numAccounts;
  }

  public void close() {
    name += " CLOSED";
    balance = 0;
    numAccounts --;
  }

  public int getBalance() {
    return balance;
  }

  public String getName() {
    return name;
  }

  public long getAccountNum() {
    return accNumber;
  }

  public String toString() {
    return "Name: " + name + "| Balance: " + balance + "| Account Number: " + accNumber;
  }
}
