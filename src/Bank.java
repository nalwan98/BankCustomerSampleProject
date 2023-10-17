import java.io.*;

public class Bank {
	
	 public static AccountActivity[] log = new AccountActivity[500];
	 public static int numactivity = 0;
	 private  Checkingaccount chkaccount ; // created to use in suspend and reactivate methods
	 private Creditaccount creaccount ;   // created to use in suspend and reactivate methods

	 public Bank() {
		//Default constructor 
	 }
	 
	 public static void sortAccountLog(AccountActivity[] sort)  { // (insertion)ascending sorted by sin number then time and date
		int n = numactivity;
		for(int i =1; i < n; i++) {
			AccountActivity cur = sort[i]; 
			int j = i;
			while(j>0 && Integer.parseInt(sort[j-1].customer.sinnumber )> Integer.parseInt(cur.customer.sinnumber )) {
				sort[j] = sort[j-1];
				j--;
			}
	
			sort[j] = cur;
		}

	 }
	public static void saveAccountLog(File file){ //prints to a file, used java.io library
		int n = numactivity;
		for(int i = 0; i < n ; i++) {
			FileWriter fr;
			try {
				fr = new FileWriter(file, true);
				fr.write(Bank.log[i].print()+"\n");
				fr.close();
			} catch (IOException e) {
			
			}
		}
	 }
	
	public static void retrieveAccountLog(File file) { //prints to a file, used java.io library
		try(FileReader fileReader = new FileReader(file)) {
		    int c = fileReader.read();
		    while(c != -1) {
		        System.out.print((char)c);
		        c = fileReader.read();
		    }
		} catch (FileNotFoundException e) {
		  
		} catch (IOException e) {
		
		}
		
	}
	
	public void suspendAccount(Customer customer, String type) {
		if(type.equals("checking")) {
			if(customer.checkAccount == null) {
				System.out.println("customer doesnt have a checking account");
			}
			else {
			chkaccount = customer.checkAccount; // to store the data
			customer.checkAccount = null; //suspend account
			AccountActivity sus = new AccountActivity(customer, "Bank", "checking account has been suspended ");
			Bank.log[Bank.numactivity++] = sus; // add activity to bank activity log
			
			System.out.println("checking account has been suspended");
		}}
		else if (type.equals("credit")) {
			if(customer.credAccount == null) {
				System.out.println("customer doesnt have a credit account");
			}
			else {
			creaccount = customer.credAccount; // to store the data
			customer.credAccount = null; //suspend account
			AccountActivity sus = new AccountActivity(customer, "Bank", "credit account has been suspended ");
			log[numactivity++] = sus; // add activity to bank activity log
			System.out.println("credit account has been suspended");
		}
		}
		else {
			System.out.println("account type is invalid");
		}
	}
	
	public void reactivateAccount(Customer customer, String type) {
		if(type.equals("checking")) {
			if(customer.checkAccount != null) {
				System.out.println("customer's checking account is already activated");
			}
			customer.checkAccount = chkaccount; //restore data
			chkaccount = null;  
			AccountActivity react = new AccountActivity(customer, "Bank", "checking account has been reactivated ");
			Bank.log[Bank.numactivity++] = react; // add activity to bank activity log
		}
		else if (type.equals("credit")) {
			if(customer.credAccount != null) {
				System.out.println("customer's credit account is already activated");
			}
			else{
			customer.credAccount = creaccount; //restore data
			creaccount = null;
			AccountActivity react = new AccountActivity(customer, "Bank", "credit account has been reactivated ");
			Bank.log[Bank.numactivity++] = react; // add activity to bank activity log
		}
			}
		else {
			System.out.println("account type is invalid");
		}
	}
	
	public void terminateAccount(Customer customer, String type) {
		if(type.equals("checking")) {
			customer.demandLoan =customer.checkAccount.balance; // indebtedness transferred to demand loan
			customer.checkAccount = null; //acount terminated
			AccountActivity term = new AccountActivity(customer, "Bank", "checking account has been terminated ");
			Bank.log[Bank.numactivity++] = term; // add activity to bank activity log
		}
		else if (type.equals("credit")) {
			
			customer.demandLoan =customer.credAccount.balance; // indebtedness transferred to demand loan
			customer.credAccount = null; //acount terminated
			AccountActivity term = new AccountActivity(customer, "Bank", "credit account has been terminated ");
			Bank.log[Bank.numactivity++] = term; // add activity to bank activity log
		}
	}
}
	
