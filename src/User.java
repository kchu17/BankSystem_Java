import java.util.*;
public class User 
{
	String name;
	String pass;
	String userId;
	
	public User(String myName, String myPass, String myUserID)
	{
		name = myName;
		pass = myPass;
		userId = myUserID;
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
	
	public void spend(String AccID, double amount, String type)
	{
		Scanner in = new Scanner(System.in);
		AccID = in.next();
		in.close();
		Scanner in2 = new Scanner(System.in);
		amount = in2.nextInt();
		in2.close();
		Scanner in3 = new Scanner(System.in);
		type = in.next();
		in3.close();
		
	}
}
