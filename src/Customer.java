

public class Customer {

	 protected String firstName;
	 protected String lastName;
	    String sinnumber;
	    int numofaccount = 1;	//number of account, by default is 1, to be a customer you must have at leat one account
	    Checkingaccount checkAccount ; // set to null if not instantiated 
	    Creditaccount credAccount ; // set to null if not instantiated 
	    protected int demandLoan = 0; // acts like the demand loan, only used if account is terminated

	    Customer(String firstName, String lastName, String number, Checkingaccount account) {   
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.sinnumber = number;
	        this.checkAccount = account;
	     }

	    Customer(String firstName, String lastName, String number, Creditaccount cAccount) {   
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.sinnumber = number;
	        this.credAccount = cAccount;
	    }

}