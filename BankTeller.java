import java.util.Scanner;

public class BankTeller {

	private static Bank a = new Bank(5);

	public static void main(String[] args) {

		char command;
		Scanner input = new Scanner(System.in);
		printMenu();

		do {
			// ask a user to choose a command
			System.out.println("\nPlease enter a command or type ?");
			command = input.nextLine().toLowerCase().charAt(0);
			BankAccount b;

			switch (command) {
			case 'a': // add an account
				int savingsOrChecking = -1;
				while (savingsOrChecking < 1 || savingsOrChecking > 2) {
					System.out.print("\nEnter 1 for a Savings Account or 2 for a Checking Account: ");
					// Brakes if you put in chars
					savingsOrChecking = Integer.parseInt(input.nextLine());
				}
				System.out.print("Enter name: ");
				String name = input.nextLine();

				if (savingsOrChecking == 1) {
					System.out.print("Enter interest amount: ");
					double interest = Double.parseDouble(input.nextLine());
					b = new SavingsAccount(name, interest);
				} else {
					System.out.print("Enter check number: ");
					int checkNumber = Integer.parseInt(input.nextLine());
					b = new CheckingAccount(name, checkNumber);
				}
				// b = new BankAccount(name);
				if (a.add(b))
					System.out.print("\nAccount successfully added.\n");
				else
					System.out.print("Account not added. No duplicates please.\n");
				break;

			case 'b': // remove an account
				System.out.print("\nEnter Account Number: ");
				int accountNumber = Integer.parseInt(input.nextLine());
				if (a.remove(a.find(accountNumber)))
					System.out.print("\nAccount successfully removed.\n");
				else
					System.out.print("Account not found. Cannot remove.\n");
				break;

			case 'c': // display the accounts
				System.out.print(a.toString());
				break;

			case 'd': // count the vehicles
				System.out.println("\nThere are " + a.getCount() + " Accounts in the bank");
				break;

			case 'e': // sort the accounts
				a.sort();
				System.out.print("Accounts sorted\n");
				break;

			case 'f': // update an account
				System.out.print("\nEnter account number: ");
				int acctNumber = Integer.parseInt(input.nextLine());
				BankAccount c = a.find(acctNumber);
				if (a.contains(c) == false) {
					System.out.print("\nTransaction failed");
					break;
				}
				System.out.print("\nEnter 1 for deposit or 2 for withdraw:");
				int choice = Integer.parseInt(input.nextLine());
				System.out.print("\nEnter amount: ");
				Double amt = Double.parseDouble(input.nextLine());
				if (choice == 1) {
					if (c.deposit(amt)) {
						System.out.print("\nTransaction successful\n");
						System.out.print(a.find(acctNumber) + "\n");
						break;
					}
				} else if (choice == 2) {
					if (c.withdraw(amt)) {
						System.out.print("\nTransaction successful\n");
						System.out.print(a.find(acctNumber) + "\n");
						break;
					}
				}
				System.out.print("\nTransaction failed\n");
				break;

			case '?':
				printMenu();
				break;
			case 'q':
				System.out.println("GOOD BYE!");
				break;
			default:
				System.out.println("Invalid Input");

			}

		} while (command != 'q');

		input.close();

	}

	public static void printMenu() {
		System.out.print("\nBank Teller Options\n" + "-----------------------------------\n"
				+ "a: add an account to the bank\n" + "b: remove an account from the bank\n"
				+ "c: display the accounts in the bank\n" + "d: count the accounts in the bank\n"
				+ "e: sort the accounts in the bank\n" + "f: update an account in the bank\n"
				+ "?: display the menu again\n" + "q: quit this program\n");

	}
}
