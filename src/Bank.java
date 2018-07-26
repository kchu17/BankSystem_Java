import java.util.*;
public class Bank 
{
	public Bank()
	{
		showLoginScreen();
		showSignUp();
	}
	
	
	public static void showLoginScreen() //Shows signup and and login
	{
		String tmp = null;
		String name = null;
		String password = null;
		String name2 = null;
		System.out.println("Welcome to the Bank!");
        System.out.println("--------------------");
        System.out.println("Choose an option:");
        System.out.println("1. Sign Up");
        System.out.println("2. Login ");
        System.out.println("--------------------");
        
        System.out.println("");
        
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        if(choice.equals("1")){
            System.out.println("Sign Up");
            System.out.println("_________");
            System.out.println("Choose a name: ");
            name = in.next();
            System.out.println("Choose a password: ");
            password = in.next();
            System.out.println("Choose an ID");
            name2 = in.next();
            System.out.println("Welcome " + name + ", Your Password is: " + password + ", Your User ID is: " + name2);
            
            
        }
        else if (choice.equals("2"))
        {
            System.out.println("Log in");
            System.out.println("Enter Username: ");
            tmp = in.next();
            if(tmp.equals(name))
            {
            	
            }
            System.out.println("Password: ");
        }
        else{
            System.out.println("Please choose an option between 1 and 2");
            showLoginScreen();
        }
    }
	}

