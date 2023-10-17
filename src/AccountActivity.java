
public class AccountActivity {
	
	protected Customer customer;
	private String accounttype;
	private String Activity;	//a description of the activity log
	AccountActivity(Customer customer, String accounttype, String Activity){
		this.customer = customer;
		this.accounttype = accounttype;
		this.Activity = Activity;
	}
	public String print() { 
		return customer.sinnumber +" -"+ customer.firstName + " "+ customer.lastName +"- " + accounttype +"- "+ Activity;
	}

}
