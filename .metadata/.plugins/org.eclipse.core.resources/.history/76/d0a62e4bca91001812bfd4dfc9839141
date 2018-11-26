import java.util.*;
public class Bank 
{
	private ArrayList<User> users;
	private int numOfUsers;
	private int numOfAcc;
	
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
        System.out.println("Choose a password: ");
        String password = in.nextLine();
        System.out.println("Welcome " + name + ", Your Password is: " + password);
        User user = new User(name, password, numOfUsers);
        users.add(user);
        numOfUsers++;
        System.out.println("Bank Account Created");
        showLogin();
	}
	
	//Validation
	
	
	public void showLogin()
	{
		 Scanner in = new Scanner(System.in);
		 System.out.println("Log in");
		 System.out.println("Enter your Username: ");
		 String name = in.nextLine();
		 System.out.println("Enter your password: " );
		 String password = in.nextLine();
		 for(int i = 0; i < users.size(); i++)
		 {
			 if(users.get(i).getName().equals(name))
			 {
				 if(password.equals(users.get(i).getPassword()))
					 {
					 	showHomepage(users.get(i));
					 }
			 }
		 
		 }	 
	}
	
	public void showHomepage(User user)
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
			showHomepage(user);
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
			//Create saving account	
		}
		else if(type.equals("2"))
		{
			//Create a checkings account
		}
		else
		{
			System.out.println("Choose a valid option");
			showCreateAccount(user);
		}
	}
	
	public void createAccount(String type, User user)
	{
		
	}
}

