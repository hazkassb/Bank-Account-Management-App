package bankAccount;

public class LedgerEntry {
	private String reason; 		//The reason for the withdrawal
	private double amount; 		//The amount in the account
	private double depositWithdrawAmnt;		//Amount to deposit or withdraw
	private String entryType; 		//Entry type is either Checking or Saving
	
//	Default constructor
	public LedgerEntry() {
		super();
		entryType = " ";		//set to empty string
		reason = " ";			// set reason to empty string
		amount = 0.0; 			//set reason to 0.0
		depositWithdrawAmnt = 0.0;		//set the amount to deposit or withdraw to zero
	}
	
	public void addEntry(String pEntryType, String preason, 
			double pDepositWithdrawAmnt, double pCurrentAmnt) {
		this.entryType = pEntryType;
		this.reason = preason;
		this.depositWithdrawAmnt = pDepositWithdrawAmnt;
		this.amount = pCurrentAmnt;
	}
	
	//Display the entry in the ledger based upon the info stored in the specified
	//ledger entry. Use printf statement to format the amount
	public void displayEntry() {
		System.out.println("--------------------------------------------------------");
		System.out.println("Entry Type: " + reason);
		if(reason != null) {
			System.out.println("Reason: " + reason);
		}
		
		System.out.printf("Amount: $%.2f\n", depositWithdrawAmnt);
		System.out.printf("Current Amount: $%.2f\n", amount);
		
		System.out.println("--------------------------------------------------------");
	}

}
