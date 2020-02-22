package bankAccount;

public class Account {
	private String name;		//Name of Acccount
	private String accountNumber;	//Account number as a string
	private double currentAmount;	//Current amount of money in the account
	private LedgerEntry[] accountLedger;	//An array of AccountLedger entries --
	
	private int ledgerEntryCount;		//Number of entries in the ledger thus far
	private final int MAX_ENTRIES = 100;	//User can only enter in a maximum of 100 entries
	
	
//	Constructor
	public Account() {
		//Set the account name to the empty string
		name = " ";
		//Set the account number to the empty string
		accountNumber = " ";
		//Set the current amount of money in the account to zero
		currentAmount = 0;
		//Set the number of entries in the ledger to zero
		ledgerEntryCount = 0;
		//initialize the ledger
		initLedger();
		
	}
	
//	Overloaded constructor
	public Account(String name, String accountNumber, double pAmount) {
		super();
//		Set the account name, number and amount to the values passed in by the user
		this.name = name;
		this.accountNumber = accountNumber;
		this.currentAmount = pAmount;
		ledgerEntryCount = 0;		//Set the number of entries in the ledger to zero
		//Initialize the ledger
		initLedger();
	}
	
	private void initLedger() {
//		Allocate enough space in memory for the maximum number of entries in the array
		accountLedger = new LedgerEntry[MAX_ENTRIES];
		
		//Create an array with the initial amount in the ledger
		accountLedger[ledgerEntryCount] = new LedgerEntry();
		accountLedger[ledgerEntryCount].addEntry("Deposit", "Initial Deposit", 
				currentAmount, currentAmount);
		ledgerEntryCount += 1;
	}
	
	public void withdraw(double pWithdrawAmnt, String pReason) {
		currentAmount -= pWithdrawAmnt;
		accountLedger[ledgerEntryCount] = new LedgerEntry();
		//Add an entry into the ledger for the account
		accountLedger[ledgerEntryCount].addEntry("Withdrawal", pReason, pWithdrawAmnt, currentAmount);
		ledgerEntryCount += 1;
	}
	
	public void deposit(double pDepAmnt) {
		currentAmount += pDepAmnt;
		accountLedger[ledgerEntryCount] = new LedgerEntry();
		//Add a deposit entry into the ledger for the account
		accountLedger[ledgerEntryCount].addEntry("Deposit", null, pDepAmnt, currentAmount);
		ledgerEntryCount += 1;
	}
	
	public void displayLedgerEntries() {
		System.out.println("Account Name: " + getName());
		System.out.println("Acount Number: " + getAccountNumber());
		System.out.println("************************************************************8*");
		
		//Display all of the entries in the ledger with understanding that the way the
		//program was written we add one to the ledger AFTER the entry has been made
		for(int i = 0; i < ledgerEntryCount; i++) {
			accountLedger[i].displayEntry();
		}
		System.out.println("************************************************************8*");
		
	}
	//getAccountNumber and setAccountNumber
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	//getName and setName
	private String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	//getCurrentAmount and setCurrentAmount
	public double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}
	
	//

}
