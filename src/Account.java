import java.util.*;
import java.time.LocalDateTime;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Account 
{
	private int accID;
	private double balance;
	private String type;
	private int count;
	private ArrayList<Transaction> transactions;
	
	public Account(int myAccId, String myType)
	{
		accID = myAccId;
		this.balance = 0;
		type = myType;
		count = 0;
		this.transactions = new ArrayList<Transaction>();
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void deposit(double amount, String type)
	{
		balance = balance + amount;
		LocalDateTime time = java.time.LocalDateTime.now();
		if(transactions.size() < 10)
		{
			Transaction newTransaction = new Transaction(count, amount, type, time);
			count++;
		    transactions.add(newTransaction);
		}
		else
		{
			transactions.remove(0);
			Transaction newTransaction = new Transaction(count, amount, type, time);
			count++;
			transactions.add(newTransaction);
		}
	}
	
	public void withdraw(double amount, String type)
	{
		balance = balance - amount;
		LocalDateTime time = java.time.LocalDateTime.now();
		if(transactions.size() < 10)
		{
			Transaction newTransaction = new Transaction(count, -amount, type, time);
			count++;
		    transactions.add(newTransaction);
		}
		else
		{
			transactions.remove(0);
			Transaction newTransaction = new Transaction(count, -amount, type, time);
			count++;
			transactions.add(newTransaction);
		}
	}
	
	public int getAccID()
	{
		return accID;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void printTransactionLog()
	{
		System.out.println("Account ID: " + getAccID());
		System.out.println("Account ID: " + getBalance());
		System.out.println("Account ID: " + getType());
		if(transactions.size() == 0)
		{
			System.out.println("Empty transactions");
		}
		for(int i = 0; i < transactions.size(); i++)
		{
			Transaction transaction = transactions.get(i);
			System.out.println(transaction.getTransactionID() + "  " + transaction.getTime() + "  " + transaction.getType() + "  " + transaction.getAmount());
		}		
		try
		{
			File file = new File("TransactionLog.txt");
			if(!file.exists())
			{
				file.createNewFile();
			}
			PrintWriter writer = new PrintWriter(file);
			writer.println("");
			writer.println("Account ID: " + getAccID());
			writer.println("Balance: " + getBalance());
			writer.println("Type: " + getType());
			if(transactions.size() == 0)
			{
				writer.println("Empty transactions.");
			}
			for(int i = 0; i < transactions.size(); i++)
			{
				Transaction transaction = transactions.get(i);
				writer.println(transaction.getTransactionID() + " " + transaction.getTransactionID() + "  " + transaction.getTime() + "  " + transaction.getType() + "  " + transaction.getAmount());
			}
			writer.close();
		}
		catch (IOException e)
		{
			e.getStackTrace();
		}
	}
	
	public void printTransactionLog(String type)
	{
		System.out.println("Account ID: " + getAccID());
		System.out.println("Account ID: " + getBalance());
		System.out.println("Account ID: " + getType());
		if(transactions.size() == 0)
		{
			System.out.println("Empty transactions");
		}
		for(int i = 0; i < transactions.size(); i++)
		{
			Transaction transaction = transactions.get(i);
			if(transaction.getType().equals(type))
			{
				System.out.println(transaction.getTransactionID() + "  " + transaction.getTime() + "  " + transaction.getType() + "  " + transaction.getAmount());	
			}	
		}
		try
		{
			String fileName = "TransactionLog_" + type + ".txt";
			File file = new File(fileName);
			if(!file.exists()) 
			{
				file.createNewFile();
			}
			PrintWriter writer = new PrintWriter(file);
			writer.println("");
			writer.println("Account ID: " + getAccID());
			writer.println("Balance: " + getBalance());
			writer.println("Type: " + getType());
			if(transactions.size() == 0)
			{
				System.out.println("Empty transactions");
			}
			for(int i = 0; i < transactions.size(); i++)
			{
				Transaction transaction = transactions.get(i);
				if(transaction.getType().equals(type))
				{
					System.out.println(transaction.getTransactionID() + "  " + transaction.getTime() + "  " + transaction.getType() + "  " + transaction.getAmount());	
				}	
			}
			writer.close();
		}
		catch(IOException e)
		{
			e.getStackTrace();
		}
	}
	
//	public static void main(String[] args)
//	{
//		
//	}
}


