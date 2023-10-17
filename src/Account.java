
public abstract class Account {
	
    
	protected int balance = 0; //account balance
	protected AccountActivity[] logaccount = new AccountActivity[200]; //activity log for customer
	protected int numActAccount = 0; //number of activities in the account by customer
	
	
	
	public Account() {
			//Default constructor 
	}
	
public abstract void withdrawAmount(Customer customer, int amount); //implemented in checkingaccount and creditccount classes

public abstract void setLimit(Customer customer,int limit); //implemented in checkingaccount and creditccount classes



	


public void depositAmount(Customer customer, int amount) {
	if(amount <= 0) {
		System.out.println("amount is invalid");
	}
balance = balance + amount;
AccountActivity deposit = new AccountActivity(customer, " ", "deposit");
Bank.log[Bank.numactivity++] = deposit; // add activity to bank activity log
logaccount[numActAccount++] = deposit;  // add activity to account activity log

}

public int getBalance() {
	return balance; //getter
}

public void createAccount(Customer customer, String type ) {
	if (type.equals("checking")) {
		if(customer.checkAccount != null) {
			System.out.print("Cannot have more than 1 checking account");
		}
		else {
			customer.numofaccount ++; // number of accounts ++ for the customer when an account is created
			Checkingaccount A = new Checkingaccount(customer.sinnumber);
			System.out.println("checking account has been created");
			customer.checkAccount = A; //create checkaccount for the customer
			AccountActivity create = new AccountActivity(customer, "Credit", "create a new Checking account");
			Bank.log[Bank.numactivity++] =create; // add activity to bank activity log
			logaccount[numActAccount++] = create; // add activity to account activity log
		}
	}
	if (type.equals("credit")) {
		if(customer.credAccount != null) {
			System.out.print("Cannot have more than 1 Credit account");
		}
		else {
			customer.numofaccount ++; // number of accounts ++ for the customer when an account is created
			Creditaccount A = new Creditaccount(customer.sinnumber);
			System.out.println("credit account has been created");
			customer.credAccount = A; //create credaccount for the customer
			AccountActivity create = new AccountActivity(customer, "Checking", "create a new Credit account");
			Bank.log[Bank.numactivity++] =create; // add activity to bank activity log
			logaccount[numActAccount++] = create; // add activity to account activity log
		}
	}
}

public void cancelAccount(Customer customer, String type) {
	if (type.equals("checking")) {
		if(customer.checkAccount == null) {
			System.out.print("you dont have a checking account");
		}
		else {
	customer.numofaccount --; // number of accounts -- for the customer when an account is canceled
	customer.checkAccount = null; //cancel checkaccount for the customer
	System.out.println(type + "checking account has been canceled");
	AccountActivity cancel = new AccountActivity(customer, "credit", "cancel Checking account");
	Bank.log[Bank.numactivity++] = cancel; // add activity to bank activity log
	logaccount[numActAccount++] = cancel; // add activity to account activity log
}}
	if (type.equals("credit")) {
		if(customer.credAccount == null) {
			System.out.print("you dont have a Credit account");
		}
		else {
	customer.numofaccount --; // number of accounts -- for the customer when an account is canceled
	customer.credAccount = null; //cancel credaccount for the customer
	System.out.println(type + "credit account has been canceled");
	AccountActivity cancel = new AccountActivity(customer, "checking", "cancel Credit account");
	Bank.log[Bank.numactivity++] = cancel; // add activity to bank activity log
	logaccount[numActAccount++] = cancel; // add activity to account activity log
}}
	else {
		System.out.print("account type is invalid");
	}
}
	

public void transferAmount(Customer customer, String fromAcc, String toAcc, int amount) {
	if(fromAcc.equals("checking") && toAcc.equals("credit") ) { // a customer can only have one checking and one credit and can only transfer between them
		customer.checkAccount.withdrawAmount(customer, amount);
		customer.credAccount.depositAmount(customer, amount);
	
	}
	else if(fromAcc.equals("credit") && toAcc.equals("checking") ) {
	customer.credAccount.balance = balance - amount;
	customer.checkAccount.balance = balance + amount;
	}
	else {
		System.out.println("invalid transaction");
	}
}





}




