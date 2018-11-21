import java.time.LocalDateTime;
import java.util.*;

public class Transaction implements Comparable
{
	private LocalDateTime time;
	private int transactionID;
	private double amount;
	private String type;
	
	public Transaction(int transactionID, double amount, String type, LocalDateTime time)
	{
		this.transactionID = transactionID;
		this.amount = amount;
		this.type = type;
		this.time = time;
//		Scanner in = new Scanner(System.in);
//		TransactionID = in.next();
//		this.TransactionID = TransactionID;
//		amount = in.nextDouble();
//		this.amount = amount;
//		type = in.next();
//		if(!type.equalsIgnoreCase("Food") || !type.equalsIgnoreCase("Gas") || !type.equalsIgnoreCase("Bills") || !type.equalsIgnoreCase("Transfer")
//				|| !type.equalsIgnoreCase("Clothes") || !type.equalsIgnoreCase("Deposit")||!type.equalsIgnoreCase("Withdrawl"))
//		{
//			System.out.println("Enter a valid type");
//		}
//		else
//		{
//			this.type = type;
//		}
//		in.close();
	}
	
	
	public LocalDateTime getTime()
	{
		return time;
	}
	
	public String getType()
	{
		return type;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public int getTransactionID()
	{
		return transactionID;
	}
	
	
	public int compareTo(Object object)
	{
		LocalDateTime other = (LocalDateTime) object;
		if(this.time.isAfter(other))
		{
			return 1;
		}
		else if(this.time.isBefore(other))
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
//	public static void main(String[] args)
//	{
//		
//	}
}
