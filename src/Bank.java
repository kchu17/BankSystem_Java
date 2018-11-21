import java.util.*;
public class Tester
{	
	public static void main(String[] args) 
	{
		Bank bank = new Bank();
	}
}

public class Bank 
{
	private ArrayList<User> users;
	private int numOfUsers;
	private int numOfAcc;
	private User currUser;
	
	public Bank()
	{	
		this.users = new ArrayList<User>();
		this.numOfUsers = 0;
		this.numOfAcc = 0;
		showLoginScreen();
	}
	
	
	public void showLoginScreen() //Shows signup and and login
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Bank!");
        System.out.println("--------------------");
        System.out.println("Choose an option:");
        System.out.println("1. Sign Up");
        System.out.println("2. Login ");
        System.out.println("--------------------");
        System.out.println("");
        
        String choice = in.next();
        if(choice.equals("1"))
        {
        	showSignUp();
        }
        else if (choice.equals("2"))
        {
           showLogin();
        }
        else
        {
            System.out.println("Please choose an option between 1 and 2");
            showLoginScreen();
        }
    }
	
	public void showSignUp()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Sign Up");
        System.out.println("_________");
        System.out.println("Choose a name: ");
        String name = in.nextLine();
        if(name.equals("") || name.equals(" "))
        {
        	System.out.println();
        	showSignUp();
        }
        else if(usernameAlreadyExists(name))
        {
        	System.out.println("Username taken - Please try Again");
        	showSignUp();
        }
        else
        {
        	System.out.println("Choose a password: ");
            String password = in.nextLine();
            if(password.equals(""))
            {
            	System.out.println("Enter a valid password");
            	System.out.println("Welcome " + name + ", Your Password is: " + password);
            	showSignUp();
            }
            else
            {
            	 User user = new User(name, password, numOfUsers);
                 users.add(user);
                 numOfUsers++;
                 
                 //basically logs in the user by saving the user as currUser
                 currUser = user;
                 
                 System.out.println("Bank Account Created");
                 showHomepage();
            }
        }
       
	}
	
	
	
	public void showLogin()
	{
		 Scanner in = new Scanner(System.in);
		 System.out.println("Log in");
		 System.out.println("Enter your Username: ");
		 String name = in.nextLine();
		 {
			 if(name.equals(""))
			 {
				 System.out.println("Enter a valid username");
				 showLogin();
			 }
			 else
			 {
				 System.out.println("Enter your password: " );
				 String password = in.nextLine();
				 if(password.equals(""))
				 {
					 System.out.println("Enter a valid password: ");
				 }
				 else
				 {
					 for(User user : users)
					 {
						 if(user.getName().equals(name) && password.equals(user.getPassword()))
						 {
							 showHomepage();
								 
						 }
					 
					 }
					 System.out.println("User not Found");
				 }
			 }

		 }
	}
	
	public void showHomepage()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("HomePage");
		System.out.println("1. Create Account");
		System.out.println("2. Delete Account");
		System.out.println("3. Transfer");
		System.out.println("4. Deposit");
		System.out.println("5. Withdraw");
		System.out.println("6. Show Accounts");
		System.out.println("7. Show all Acounts");
		System.out.println("8. Delete user");
		System.out.println("9. Logout");
		System.out.println("10. Quit");
		System.out.println("");
		String choice = in.next();
		if(choice.equals("1"))
		{
			//Create Account
		}
		else if(choice.equals("2"))
		{
			//Delete Account
		}
		else if(choice.equals("3"))
		{
			//Transfer
		}
		else if(choice.equals("4"))
		{
			//Deposit
		}
		else if(choice.equals("5"))
		{
			//Withdraw
		}
		else if(choice.equals("6"))
		{
			//Show Accounts
		}
		else if(choice.equals("7"))
		{
			//Show All Accounts
		}
		else if(choice.equals("8"))
		{
			//Delete User
		}
		else if(choice.equals("9"))
		{
			//Logout 
		}
		else if(choice.equals("10"))
		{
			//Quit
		}
		else
		{
			System.out.println("Enter a valid option");
			showHomepage();
		}
	}
	
	public void showCreateAccount(User user)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("1. Create Savings Account");
		System.out.println("2. Create Checkings Account");
		System.out.println("Choose an option: ");
		String type = in.nextLine();
		if(type.equals("1"))
		{
			createAccount("Savings", user);
		}
		else if(type.equals("2"))
		{
			createAccount("Checkings", user);
		}
		else
		{
			System.out.println("Choose a valid option");
			showCreateAccount(user);
		}
	}
	
	public void createAccount(String type, User user)
	{
		if(!user.accountLimit())
		{
			Account account = new Account(numOfAcc, type);
			System.out.println("Account has been created");
			numOfAcc++;
			user.addAccount(account);
		}
		else
		{
			System.out.println("You can only have 5 accounts at a time");
		}
		showHomepage();	
	}
	
	public void deleteAccount()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the ID: ");
		if(!in.hasNextInt())
		{
			System.out.println("Invalid account");
			deleteAccount();
		}
		int accID = in.nextInt();
		if(currUser.accountExistence(accID))
		{
			currUser.removeAccount(accID);
			System.out.println("Account deleted");
		}
		else
		{
			System.out.println("Account not found");
			showHomepage();
		}
	}
	
	public void transferToAnotherAccount()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter amount to transfer");
		if(!in.hasNextDouble())
		{
			System.out.println("Invalid amount");
			transferToAnotherAccount();
		}
		double amount = in.nextDouble();
		
		if(amount < 0)
		{
			System.out.println("Invalid amount");
			transferToAnotherAccount();		
		}
		System.out.println("Enter the ID of the account to transfer");
		if(!in.hasNextInt())
		{
			System.out.println("Invalid Account ID");
			transferToAnotherAccount();
		}
		int targetAccID = in.nextInt();
		
		if(accountExists(targetAccID))
		{
			System.out.println("Enter the ID of the account to withhdraw money");
			if(!in.hasNextInt())
			{
				System.out.println("Invalid Acount Id");
				transferToAnotherAccount();
			}
			int senderAccID = in.nextInt();
			
			if(currUser.accountExistence(senderAccID))
			{
	//			currUser.spend(targetAccID, amount, "Transfer");
				if(currUser.sufficientFund(senderAccID, amount))
				{
					User recipient = findRecipient(targetAccID);
					recipient.receive(targetAccID,  amount);;
				}
				else {
					System.out.println("Insufficient Funds");
				}
			}
			else
			{
				System.out.println("Account not found");
			}
		}
		else
		{
			System.out.println("Account not found");
		}
	}
	
	public void deposit()
	{
		Scanner in = new Scanner(System.in);
		if(!in.hasNextInt())
		{
			System.out.println("Invalid Account ID");
			deposit();
		}
		int accID = in.nextInt();
		
		if(currUser.accountExistence(accID))
		{
			System.out.println("Amount to deposit");
			if(!in.hasNextDouble())
			{
				System.out.println("Invalid amount");
				deposit();
			}
			else
			{
				double amount = in.nextDouble();
				if(amount < 0 )
				{
					System.out.println("Invalid amount");
					deposit();
				}
				else
				{
					currUser.depositToAccount(accID, amount);
				}
			}
		}
		else
		{
			System.out.println("Account not found");
		}
		showHomepage();
	}
	
	public void withdraw(User user)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter ID of account to withdraw");
		if(!in.hasNextInt())
		{
			System.out.println("Invalid Account ID.");
			withdraw(user);
		}
		int accID = in.nextInt();
		if(user.accountExistence(accID))
		{
			System.out.println("Enter amount to withdraw: ");
			if(!in.hasNextDouble())
			{
				System.out.println("Invalid amount");
				withdraw(user); ////or deposit(user)
			}
			double amount = in.nextDouble();
			if(amount < 0)
			{
				System.out.println("Invalid amount");
				withdraw(user); //or deposit(user)
			}
			System.out.println("Type of Transaction?");
			System.out.println("1. Food");
			System.out.println("2. Gas");
			System.out.println("3. Bills");
			System.out.println("4. Clothes");
			System.out.println("5. Withdrawal");
			System.out.println("6. Transfer");
			System.out.print("Choose an option: ");
			String choice = in.next();
			if (choice.equals("1")) 
			{
				choice = "Food";
			}
			else if (choice.equals("2")) 
			{
				choice = "Gas";
			}
			else if (choice.equals("3")) {
				choice = "Bills";
			}
			else if (choice.equals("4")) 
			{
				choice = "Clothes";
			}
			else if (choice.equals("5")) 
			{
				choice = "Withdrawal";
			}
			else if (choice.equals("6")) 
			{
				choice = "Transfer";
			}
			else
			{
				System.out.println("Choose a valid option");
				withdraw(user);
			}
			user.spend(accID,amount,choice);
		}
		else
		{
			System.out.println("Account does not exist");
		}
		showHomepage();
	}
	
	public void showAccount()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter then Account ID to see");
		if(!in.hasNextInt())
		{
			System.out.println("Invalid Account ID");
			showAccount();
		}
		else
		{
			int accID = in.nextInt();
			if(currUser.accountExistence(accID))
			{
				System.out.println("1. See all transcations");
				System.out.println("2. Transcation history by type");
				System.out.println("Choose an option: ");
				String choice = in.next();
				if(choice.equals("1"))
				{
					currUser.printAccountInfo(accID);
				}
				else if (choice.equals("2"))
				{
					System.out.println("1. Food");
					System.out.println("2. Gas");
					System.out.println("3. Bills");
					System.out.println("4. Clothes");
					System.out.println("5. Deposit");
					System.out.println("6. Withdrawal");
					System.out.println("7. Transfer");
					System.out.print("Choose a type: ");
					String transactionType = in.next();
					if (transactionType.equals("1")) 
					{
						transactionType = "Food";
					}
					else if (transactionType.equals("2")) 
					{
						transactionType = "Gas";
					}
					else if (transactionType.equals("3")) 
					{
						transactionType = "Bills";
					}
					else if (transactionType.equals("4"))
					{
						transactionType = "Clothes";
					}
					else if (transactionType.equals("5")) 
					{
						transactionType = "Deposit";
					}
					else if (transactionType.equals("6")) 
					{
						transactionType = "Withdrawal";
					}
					else if (transactionType.equals("7")) 
					{
						transactionType = "Transfer";
					}
					else
					{
						System.out.println("Enter a valid option");
						showAccount();
					}
					currUser.printAccountInfo(accID, transactionType);
				}
			}
			else
			{
				System.out.println("Account not found");
			}
		}
		showHomepage();
	}
	
	public void showAllAccounts(User user)
	{
		user.printAllAccountsInfo();
		showHomepage();
	}
	
	public void deleteUser(User user)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your password");
		String password = in.nextLine();
		if(password.equals(""))
		{
			System.out.println("Enter a valid password.");
			deleteUser(user);
		}
		else
		{
			user.removeAccount(findUserIndex(user));
			System.out.println("Deleted");
			showLoginScreen();
		}
	}
	
	public int findUserIndex(User user) //index of User in the ArrayList
	{
		int index = 0;
		for(int i = 0 ; i < users.size(); i++)
		{
			User temp = users.get(i);
			if(temp.getPassword().equals(user.getPassword()))
			{
				if(temp.getPassword().equals(user.getPassword()))
				{
					index = i;
					//?
				}
			}
		}
		return index;
	}
	
	public boolean usernameAlreadyExists(String username) 
	{
		boolean usernameExist = false;
		for (int i = 0; i < users.size(); i++) 
		{
			if (users.get(i).getName().equals(username)) 
			{
				usernameExist = true;
				break;
			}
		}
		return usernameExist;
	}
	
	public User findRecipient(int accID) //Find the User's chekcing/saving account with ID
	{
		User recipient = null;
		for (int i = 0; i < users.size(); i++) 
		{
			User user = users.get(i);
			if (user.accountExistence(accID)) 
			{
				recipient = user;
			}
		}
		return recipient;
	}
	
	public boolean accountExists(int accID) //Checks to see if a checking or saving with a the give Account ID exists
	{
		for (int i = 0; i < users.size(); i++) 
		{
			User user = users.get(i);
			if (user.accountExistence(accID)) 
			{
				return true;
			}
		}
		return false;
	}
}

