import java.io.File;

public class test {

	public static void main(String[] args) {
		 
	Bank bank = new Bank();
	Checkingaccount a = new Checkingaccount("2345");
	Customer amer = new Customer("amer", "aja", "2345", a);
	a.setLimit(amer, -200);
	a.setOverdraftOption(amer, "A2");
	Checkingaccount ab = new Checkingaccount("1089");
	Customer amera = new Customer("amera", "ajan", "1089", ab);
	ab.setLimit(amera, -200);
	ab.setOverdraftOption(amera, "A2");
	Checkingaccount abc = new Checkingaccount("2000");
	Customer ameran = new Customer("ameran", "ajani", "2000", abc);
	abc.setLimit(ameran, -200);
	abc.setOverdraftOption(ameran, "A2");
	System.out.println(amer.numofaccount);
	a.createAccount(amer,"credit");
	amer.credAccount.limit = 1000;
	amer.checkAccount.balance = 500;
	System.out.println(amer.numofaccount);
	System.out.println(amer.credAccount.getBalance());
	a.transferAmount(amer, "checking", "credit", 300);
	System.out.println(amer.credAccount.getBalance());
	System.out.println(amer.checkAccount.getBalance());
	a.transferAmount(amer, "credit", "checking", 100);
	System.out.println(amer.checkAccount.getBalance());
	a.transferAmount(amer, "checking", "credit", 500);
	System.out.println(amer.checkAccount.getBalance());
	a.cancelAccount(amer, "credit");
	System.out.println(amer.numofaccount);
	for(int i = 0; i < Bank.numactivity ; i++) {
		System.out.println(Bank.log[i].print());
	}
	Bank.sortAccountLog(Bank.log);
	for(int i = 0; i < Bank.numactivity ; i++) {
		System.out.println(Bank.log[i].print());
	}
	File file = new File("wow");
	
	Bank.retrieveAccountLog(file);
	bank.suspendAccount(amer, "checking");
	bank.reactivateAccount(amer, "checking");
	System.out.println(amer.checkAccount.getBalance());
	for(int i = 0; i < amer.checkAccount.numActAccount ; i++) {
		System.out.println(amer.checkAccount.logaccount[i].print());
	}
	
	
}
	
} 