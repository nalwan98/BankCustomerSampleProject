


public class Checkingaccount extends Account {

	
	private String overdraft;
	private int limit;
	
	
	
	
	public Checkingaccount(String sin) {
		super();
		//Default constructor 
		
	}
	

	public void setOverdraftOption(Customer customer, String od){
		this.overdraft = od; //od is either A1: no overdraft plan, A2: pay per use, A3: monthly
		AccountActivity setod = new AccountActivity(customer, "checking", "setting overdraftt");
		Bank.log[Bank.numactivity++] = setod; // add activity to bank activity log
		logaccount[numActAccount++] = setod; // add activity to account activity log
	}
	
	@Override
	public  void setLimit(Customer customer, int limit) {
	this.limit = limit;  //setter
	AccountActivity lim = new AccountActivity(customer, "checking", "settinglimit");
	Bank.log[Bank.numactivity++]  =lim;  // add activity to bank activity log
	logaccount[numActAccount++] = lim;  // add activity to account activity log
	}
	
	@Override
	public void withdrawAmount(Customer customer, int amount) {
		if(balance - amount < 0) {
			if(overdraft.equals("A1")) { // no overdraft plan
				System.out.println("amount is less than balance, no overdraft plan");
			}
			if(overdraft.equals("A2")) { // per use overdraft
				if (balance - amount <= limit ) {
					System.out.println("passed the limit of the plan, cannot proceed transaction");
				}
				else {
				balance = balance - amount;
				balance = balance - 5; //pay per use fee
				System.out.println("overdraft per use plan is used");
			}
			}
			if(overdraft.equals("A3")) { // monthly plan
				if (balance - amount <= limit) {
					System.out.println("passed the limit of the plan, cannot proceed transaction ");
				}
				else
				balance = balance - amount;
				System.out.println(" overdraft per use plan is used");
			}
		}
		else balance = balance - amount;	//when amount <= balance
		AccountActivity withd = new AccountActivity(customer, "checking", "withdraw");
		Bank.log[Bank.numactivity++] = withd;  // add activity to bank activity log
		logaccount[numActAccount++] = withd;   // add activity to account activity log
	}
	
	
	
	

	


	
}
