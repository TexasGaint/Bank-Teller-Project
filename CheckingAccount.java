
public class CheckingAccount extends BankAccount {
	
	private int checkNumber;
	
	public CheckingAccount (String name, int checkNumber) {
		super(name);
		if (checkNumber > 0)
			this.checkNumber = checkNumber;
		else
			this.checkNumber = 1000;
	}

	public int getCheckNumber () {
		return checkNumber;
	}
	
	public String toString () {
		writeCheck();
		return ("Checking Account\n" + super.toString() + "\n" + String.format("Next Check Number:  %04d", getCheckNumber()));
	}
	
	public void writeCheck () {
		checkNumber = checkNumber + 1;
	}
}
