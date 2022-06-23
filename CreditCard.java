/**
 * This class is the superClass for all CreditCard objects
 * that defines a credit card with its numerous variables
 * @author tyler
 */
public class CreditCard 
{
	//variables of each valid credit card
	private String cardNumber; 
	private String nameOnCard; 
	private String typeOfCard; 
	private double currentBalance; 
	//dynamic variables that differ between each card
	int creditLimit; 
	int overdraft; 
	double monthlyRebateRate; 
	boolean overdrawnStatus = false; 
	double totalMonthlySpending; 
	//class data/variable: one copy for the whole class
	static int numOfCreditCards; 

	/**
	 * constructor of type CreditCard
	 * @param cardNumber card number of the card
	 * @param nameOnCard name holder on the credit card
	 * @param typeOfCard whether it is gold, platinum, or corporate
	 * @param currentBalance current balance on the credit card
	 */
	CreditCard(String cardNumber, String nameOnCard, 
			String typeOfCard, double currentBalance)
	{
		this.cardNumber = cardNumber; 
		this.nameOnCard = nameOnCard; 
		this.typeOfCard = typeOfCard; 
		this.currentBalance = currentBalance; 
		numOfCreditCards++; 
	}//end of CreditCard constructor
	
	/**
	 * returns the card number on the card
	 * @return the card number on the card
	 */
	public String getCardNumber() 
	{
		return cardNumber; 
	}
	
	/**
	 * returns the credit limit of the card
	 * @return the credit limit of the card
	 */
	public int getCreditLimit()
	{
		return creditLimit; 
	}
	
	/**
	 * returns the current balance of the card
	 * @return the current balance of the card
	 */
	public double getCurrentBalance()
	{
		return currentBalance; 
	}
	
	/**
	 * returns the monthly rebate rate of the card
	 * @return the monthly rebate rate of the card
	 */
	public double getMonthlyRebateRate()
	{
		return monthlyRebateRate; 
	}
	
	/**
	 * returns the name of the card holder on the card
	 * @return the name of the card holder on the card
	 */
	public String getNameOnCard() 
	{
		return nameOnCard; 
	}
	
	/**
	 * returns the overdraft limit of the card
	 * @return the overdraft limit of the card
	 */
	public int getOverdraft()
	{
		return overdraft; 
	}
	
	/**
	 * returns the overdrawn status of the card
	 * @return the overdrawn status of the card
	 */
	public boolean getOverdrawnStatus()
	{
		return overdrawnStatus; 
	}
	
	/**
	 * returns the total monthly spending of the card
	 * @return the total monthly spending of the card
	 */
	public double getTotalMonthlySpending()
	{
		 return totalMonthlySpending; 
	}
	
	/**
	 * returns the type of card; either gold, platinum, or corporate
	 * @return the type of card
	 */
	public String getTypeOfCard() 
	{
		return typeOfCard; 
	}
	
	/**
	 * sets the new current balance with purchase added to it
	 * @param purchase the purchase amount on the specified transaction
	 * @return the new current balance with the added purchase
	 */
	public double setCurrentBalance(double purchase)
	{
		 return currentBalance += purchase; 
	}
	
	/**
	 * sets the overdrawn status variable to true
	 */
	public void setOverdrawnStatus()
	{
		overdrawnStatus = true; 
	}
	
	/**
	 * adds the purchase to the card for the whole total month of spending
	 * @param purchase the purchase amount on the specified transaction
	 * @return the total monthly spending 
	 */
	public double setTotalMonthlySpending(double purchase)
	{
		 return totalMonthlySpending += purchase; 
	}

	@Override
	public String toString() 
	{
		return "CreditCard [cardNumber=" + cardNumber + ", holderName=" 
				+ nameOnCard + ", typeOfCard=" + typeOfCard
				+ ", currentBalance=$" + currentBalance + ", creditLimit=" 
				+ creditLimit + ", overdraft=" + overdraft
				+ ", monthlyRebate=" + monthlyRebateRate + "]"; 
	}//end of CreditCard toString()
}//end CreditCard class