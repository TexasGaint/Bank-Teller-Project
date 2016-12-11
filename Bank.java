
// Name: Ryan Maharrey
// Assignment: PA13 Bank
// Description: This class is used to create BankAccount objects

public class Bank {
	private BankAccount[] accounts;
	private int count;

	public Bank(int cap) {
		accounts = new BankAccount[cap];
		count = 0;
	}

	private int indexOf(BankAccount a) {
		if (a == null)
			return -1;
		for (int i = 0; i < count; i++)
			if (accounts[i].equals(a))
				return i;
		return -1;
	}

	public boolean contains(BankAccount a) {
		for (int i = 0; i < count; i++) {
			if (accounts[i] == a)
				return true;
		}
		return false;
	}

	public boolean add(BankAccount a) {
		if (contains(a))
			return false;

		if (full()) {
			doubleCapacity();
		}
		accounts[count] = a;
		count++;
		return true;
	}

	public boolean remove(BankAccount a) {
		if (!contains(a))
			return false;
		int loc = indexOf(a);

		accounts[loc] = accounts[count - 1];
		accounts[count - 1] = null;
		count--;
		return true;
	}

	public int getCount() {
		return count;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Bank Accounts\n");
		for (int i = 0; i < count; i++)
			sb.append(accounts[i] + "\n    **************    \n");
		return sb.toString();
	}

	public void sort() {

		for (int i = 0; i < count - 1; i++) {
			int min = i;
			for (int j = i; j < count; j++) {
				if (accounts[j].getAccountNumber() < accounts[min].getAccountNumber())
					min = j;
			}
			BankAccount temp = accounts[i];
			accounts[i] = accounts[min];
			accounts[min] = temp;
		}
	}

	private void doubleCapacity() {
		BankAccount[] temp = accounts;
		accounts = new BankAccount[count + 1];
		for (int i = 0; i < temp.length; i++) {
			accounts[i] = temp[i];
		}
	}

	private boolean full() {
		return count == accounts.length;
	}

	public BankAccount find(int acct) {
		for (int i = 0; i < count; i++)
			if (accounts[i].getAccountNumber() == acct)
				return accounts[i];
		return null;
	}
}