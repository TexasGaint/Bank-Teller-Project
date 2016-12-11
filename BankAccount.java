
// Name: Ryan Maharrey
// Assignment: PA12 BankAccount
// Description: This class is used to create BankAccount objects
// Hamlton Helped a lot with understanding what to do on this

//I have the testbankaccount file but unsure how you want me to submit it at all
import java.util.Date;
import java.util.Random;

public class BankAccount {

	// constructors
	protected String name;
	protected double balance;
	protected int acctNum;
	protected Date date;
	protected static int accountsCreated;

	// Setting the defaults
	public BankAccount(String name) {
		this.name = name;
		this.balance = 0;
		this.acctNum = generateAcctNum();
		this.date = new Date();
		accountsCreated++;
	}

	// Returning the balance on the account
	// Thats my basic understanding of it but anything beyond that I am not
	// sure.
	public double getBalance() {
		return balance;
	}

	// Returning he account number
	// Thats my basic understanding of it but anything beyond that I am not
	// sure.
	public int getAccountNumber() {
		return acctNum;
	}
	
	public boolean transfer(BankAccount a, double amt) {
		if (amt > 0 && this.balance >= amt) {
			this.balance -= amt;
			a.balance += amt;
			return true;
		}
		return false;
	}

	// Changes the balance + and returns true or false, even though how I have everything
	// set up, making this a boolean doesn't matter because there is no interface
	// for it to matter
	public boolean deposit(double atm) {
		if (atm >= 0) {
			balance += atm;
			return true;
		}
		return false;
	}

	// Changes the balance - and returns true or false, even though how I have everything
	// set up, making this a boolean doesn't matter because there is no interface
	// for it to matter
	public boolean withdraw(double atm) {
		if (atm <= balance && atm >= 0) {
			balance -= atm;
			return true;
		}
		return false;
	}

	// The generic print statement
	public String toString() {
		return name + " [" + acctNum + "]" + "\n" + date.toString() + "\n" + "$" + String.format("%,.2f", balance);
	}

	// A simple test to see if the bank account numbers match
	public boolean equals(BankAccount that) {
		if (this.acctNum == that.acctNum)
			return true;
		return false;
	}

	// A more complicated random number generator
	protected int generateAcctNum() {
		Random r = new Random();
		String s = r.nextInt(9) + 1 + "";
		for (int i = 1; i <= 8; i++)
			s += r.nextInt(10);
		return Integer.parseInt(s);
	}
	
	public static int getAccountsCreated() {
		return accountsCreated;
	}

}
