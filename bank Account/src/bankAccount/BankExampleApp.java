package bankAccount;

import java.util.Scanner;

public class BankExampleApp {
	private final int EXITPROGRAM = 9;		//Menu option to exit program
	private Account checkingAccount;		//A default checking account
	private Account savingAccount;			//A default saving account
//	private Scanner console;				//Object for input from the user
	
	//Default constructor instantiates the checking and savings accounts
	//with some of my personal information and some default imaginary amounts
	public BankExampleApp() {
		super();
		checkingAccount = new Account("JodyChecking", "110001", 5000.00);
		savingAccount = new Account("SavingSavinf", "110002", 15000.00);
		Scanner scan = new Scanner(System.in);
	}
	
	//Create a menu to display options to a user -- if the user
	//enters in a 9, the program exits.
	public void displayMenu() {
		Scanner scan = new Scanner(System.in);
		int response = 0;
		while(response != EXITPROGRAM) {
			System.out.println("1: Deposite Into Checking " + "\n2: Withdraw From Checking " + "\n3: Deposit Into Saving " + "\n4: Withdraw From Saving " + "\n5. Display Checking Transactions " + "\n6. Display Saving Transactions " + "\n9: Exit ");
			System.out.println("Enter a selection from  the menu: ");
			response = scan.nextInt();
			executeMenuSelection(response);
		}
	}
	
	//A private method called by displayMenu() which calls methods of the account
	//classes based upon the value entered in by the user
	
	private void executeMenuSelection(int pResponse) {
		Scanner scan = new Scanner(System.in);
		double depAmount = 0.0;
		double withdrawAmnt = 0.0;
		String reason = " ";
		
		switch(pResponse) {
		//Deposit into checking
		case 1:
			System.out.println("How much to deposit into checking? Amount must be greater than zero: ");
			depAmount = scan.nextDouble();
		while (depAmount < 0.0) {
			System.out.println("Please enter an amount greater than zero: ");
			depAmount = scan.nextDouble();
		}
		checkingAccount.deposit(depAmount);
		break;
		
		//Withdraw from checking
		case 2:
			System.out.println("How much to withdraw from checking? Amount must be greater than zero ");
			withdrawAmnt = scan.nextDouble();
			while(withdrawAmnt < 0.0) {
				System.out.println("Please enter an amount greater than zero: ");
				withdrawAmnt = scan.nextDouble();
			}
			//Need to consume the end of line
			String clearEOL = scan.nextLine();
			System.out.println("Please enter a reason for withdrawal: ");
			reason = scan.nextLine();
			checkingAccount.withdraw(withdrawAmnt, reason);
			break;
		
		//Deposit into savings
		case 3:
			System.out.println("How much to deposit into saving? Amount must be greater than zero. ");
			depAmount = scan.nextDouble();
			while(depAmount < 0.0) {
				System.out.println("Please enter an amount greater than zero: ");
				depAmount = scan.nextDouble();
			}
			savingAccount.deposit(depAmount);
			
		//Withdraw form savings
		case 4:
			System.out.println("How much to withdraw from saving? Amount must be greater than zero.");
			withdrawAmnt = scan.nextDouble();
			while(withdrawAmnt < 0.0) {
				System.out.println("Please enter an amount greater than zero: ");
				withdrawAmnt = scan.nextDouble();
			}
			clearEOL = scan.nextLine();
			System.out.println("Please enter a reason for withdrawal: ");
			reason = scan.nextLine();
			savingAccount.withdraw(withdrawAmnt, reason);
			break;
		
		//Display the ledger entries for the checking account
		case 5:
			checkingAccount.displayLedgerEntries();
			break;
			
		//Display the ledger entries for the savings account
		case 6:
			savingAccount.displayLedgerEntries();
			break;
			
		//Don't do anything but exit the program upon return
		case 9:
			break;
			
		//Default invalid entry
		default:
			System.out.println("Invalid Entry");
			break;
		}
	}
	public static void main(String[] args) {
		//Instantiate a bank object of BankExample
		//Will instantiate a single checking and savings account for the user
		
		BankExampleApp bank = new BankExampleApp();
		//Start by displaying the menu to the user
		bank.displayMenu();
	}



}
