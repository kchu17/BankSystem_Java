import java.time.LocalTime;

public class Transaction implements Comparable
{
	private int transactionID;
	private double amount;
	private String type;
	private LocalTime time;
	
	//constructor
	public Transaction(int transactionID, double amount, String type, LocalTime time)
	{
		this.transactionID = transactionID;
		this.amount = amount;
		this.type = type;
		this.time = time;
	}
	
	//returns the time of the transaction
	public LocalTime getTime()
	{
		return time;
	}
	
	//returns the type of the transaction
	public String getType()
	{
		return type;
	}
	
	//returns the amount of the transaction
	public double getAmount() 
	{
		return amount;
	}
	
	//return the transaction ID
	public int getTransactionID() 
	{
		return transactionID;
	}
	
	@Override
	public int compareTo(Object o) 
	{
		LocalTime other = (LocalTime)o;
		if (this.time.isAfter(other)) 
		{
			return 1;
		}
		else if (this.time.isBefore(other))
		{
			return -1;
		}
		else 
		{
			return 0;
		}
	}
}