
public class SavingsAccount extends BankAccount {

	private double interestRate;

	public SavingsAccount (String name, double interest) {
		super(name);
		if (interest > 0 && interest < 10)
			this.interestRate = interest;
		else
			this.interestRate = 1;
	}
	
	public double getRate () {
		return interestRate;
	}
	
	public String toString () {
		addInterest();
		return ("Savings Account\n" + super.toString() + "\n" + "Interest Rate:     %" + String.format("%4.3f", getRate()));
		
	}
	
	public void addInterest() {
		balance = balance * (getRate()/100 + 1);
	}
}
