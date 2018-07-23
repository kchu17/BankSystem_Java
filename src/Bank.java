import java.util.*;
public class Bank 
{
	public Bank()
	{
		showLoginScreen();
		signUp();
	}
	
	public static void showLoginScreen()
	{
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
            String name = in.next();
            System.out.println("Choose a password: ");
            String password = in.next();
            System.out.println("Welcome " + name + ", Your Password is: " + password);
            
        }
        else if (choice.equals("2")){
            System.out.println("Log in");
        }
        else{
            System.out.println("Please choose an option between 1 and 2");
            showLoginScreen();
        }
    }
	}
}
