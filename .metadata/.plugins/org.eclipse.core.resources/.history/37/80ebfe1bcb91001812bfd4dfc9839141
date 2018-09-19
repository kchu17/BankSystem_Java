import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Transaction 
{
	String TransactionID;
	double amount;
	String type;
	
	public Transaction(String TransactionID, double amount, String type)
	{
		Scanner in = new Scanner(System.in);
		TransactionID = in.next();
		this.TransactionID = TransactionID;
		Scanner in2 = new Scanner(System.in);
		amount = in2.nextDouble();
		this.amount = amount;
		Scanner in3 = new Scanner(System.in);
		type = in3.next();
		if(!type.equalsIgnoreCase("Food") || !type.equalsIgnoreCase("Gas") || !type.equalsIgnoreCase("Bills") || !type.equalsIgnoreCase("Transfer")
				|| !type.equalsIgnoreCase("Clothes") || !type.equalsIgnoreCase("Deposit")||!type.equalsIgnoreCase("Withdrawl"))
		{
			System.out.println("Enter a valid type");
		}
		else
		{
			this.type = type;
		}
	}
	
	
	public String getTime()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime currentTime = LocalDateTime.now();  
		return dtf.format(currentTime);
	}
	
	public String getType()
	{
		return type;
	}
	
	public double getAmount()
	{
		return amount;
	}
}
