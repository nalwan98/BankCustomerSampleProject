
public class Creditaccount extends Account {

	
	
	int limit;
	int clepenalty = 29; //CLE credit exceed limit
	
	
	public Creditaccount(String sin) {
		super();
		//Default constructor 
		}
		
	
	// overdraftoption method is only for checking account as specified under the method 
	
	@Override
	public void setLimit(Customer customer, int limit) {
	this.limit = limit;  //setter
	AccountActivity lim = new AccountActivity(customer, "credit", "settinglimit");
	Bank.log[Bank.numactivity++]  =lim;  // add activity to bank activity log
	logaccount[numActAccount++] = lim;  // add activity to account activity log
	}
	
	@Override
	public void withdrawAmount(Customer customer, int amount) {
		if(balance + limit - amount  < 0) {
			if(limit > 1000) { // High Credit Limit with Credit Limit Exceed Penalty
				System.out.println("withdrawal is declined, a Credit Exceed Limit (CLE) penalty will be charged");
				balance = balance - clepenalty;
			}
			if(limit < 1000) { //Low Credit Limit with No Credit Limit Exceed Penalty
				System.out.println("withdrawal is declined, no Credit Exceed Limit (CLE) penalty will be charged");
			}
		}
		else balance = balance - amount;  //when amount <= balance
		AccountActivity withd = new AccountActivity(customer, "checking", "withdraw");
		Bank.log[Bank.numactivity++] = withd;  // add activity to bank activity log
		logaccount[numActAccount++] = withd;  // add activity to account activity log
	}



}
