import java.util.*;
public class User 
{
	private String name;
	private String pass;
	int userId;
	private static int count = 1000;
	private ArrayList<Account> accounts;
	
	public User(String myName, String myPass, int myUserId)
	{
		name = myName;
		pass = myPass;
		userId = myUserId;
		myUserId = count;
		count++;
	}
	
	public void setPassword()
	{
		Scanner in = new Scanner(System.in);
        String newPassword = in.next();
        pass = newPassword;
        in.close();
	}
	
	public String getPassword()
	{
		return pass;
	}
	
	public void setName()
	{
		Scanner in = new Scanner(System.in);
        String newName = in.next();
        name = newName;
        in.close();
	}
	
	public String getName()
	{
		return name;
	}
	
	private int getAccountIndex(int accID) 
	{
		int index = 0;
		for (int i = 0; i < accounts.size(); i++) 
		{
			if (accounts.get(i).getAccID() == accID) 
			{
				index = i;
			}
		}
		return index;
	}
	
	public void spend(int accID, double amount, String type)
	{
		int accIndex = getAccountIndex(accID);
		Account account = accounts.get(accIndex);
		if(amount > account.getBalance())
		{
			System.out.println("Insufficient funds");
		}
		else
		{
			account.withdraw(amount, type);
			if(type.equalsIgnoreCase("Transfer"))
			{
				System.out.println("Transfer completed");
			}
		}
	}
	
	public void addAccount(Account newAccount)
	{
		if(accounts.size() < 5)
		{
			accounts.add(newAccount);
			System.out.println(newAccount.getType() + " Account created");
		}
	}
	
	public boolean accountExistence(int accID)
	{
		for(int i = 0; i < accounts.size(); i++)
		{
			if(accounts.get(i).getAccID() == accID)
			{
				return true;
			}
		}
		return false;
	}
	
	public void removeAccount(int accID) 
	{
		int index = getAccountIndex(accID);
		accounts.remove(index);
	}
	
	public void depositToAccount(int accID, double amount) 
	{
		int index = getAccountIndex(accID);
		Account account = accounts.get(index);
		account.deposit(amount, "Deposit");
	}
	
	public void printAllAccountsInfo() 
	{
		if (accounts.size() == 0) 
		{
			System.out.println("No existing accounts");
		}
		for(int i = 0; i < accounts.size(); i++) 
		{
			Account account = accounts.get(i);
			System.out.println("Account ID: " + account.getAccID());
			System.out.println("Balance: " + account.getBalance());
			System.out.println("Type: " + account.getType());
		}
	}
	
	public void printAccountInfo(int accID) 
	{
		int index = getAccountIndex(accID);
		Account account = accounts.get(index);
		account.printTransactionLog();
	}
	
	
	public void printAccountInfo(int accID, String type) 
	{
		int index = getAccountIndex(accID);
		Account account = accounts.get(index);
		account.printTransactionLog(type);
	}
	
	
	public void receive(int accID, double amount) 
	{
		int index = getAccountIndex(accID);
		Account account = accounts.get(index);
		account.deposit(amount, "Transfer");
	}
			
			
	public boolean accountLimit() 
	{
		if (accounts.size() == 5) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean sufficientFund(int accID, double amount) 
	{
		int index = getAccountIndex(accID);
		Account account = accounts.get(index);
		if (account.getBalance() >= amount) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

//	public static void main(String[] args)
//	{
//		
//	}
}
		
