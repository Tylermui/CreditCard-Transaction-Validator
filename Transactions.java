/**
 * This class is the superClass for all Transaction objects
 * that defines a transaction with its numerous variables
 * @author tyler
 */
public class Transactions 
{
	//variables of each transaction
	private String cardNumber; 
	private String transactionId; 
	private String date; 
	private String vendor; 
	private double purchaseAmount; 
	//class data/variable: one copy for the whole class
	static int numOfTransactions; 
	
	/**
	 * creates a new Transaction object with the information
	 * of the given input and counts how many there are
	 * @param cardNumber the card number of the transaction
	 * @param transactionId the number of transaction
	 * @param date the date of the transaction
	 * @param vendor the place where the transaction happened
	 * @param purchaseAmount the amount spent on the transaction
	 */
	Transactions(String cardNumber, String transactionId, String date,
			String vendor, double purchaseAmount) 
	{
		this.cardNumber = cardNumber; 
		this.transactionId = transactionId; 
		this.date = date; 
		this.vendor = vendor; 
		this.purchaseAmount = purchaseAmount; 
		numOfTransactions++; 
	}// end of Transaction constructor

	/**
	 * returns the card number on the transaction
	 * @return the card number on the transaction
	 */
	public String getCardNumber() 
	{
		return cardNumber; 
	}
	
	/**
	 * returns the date on the transaction
	 * @return the date on the transaction
	 */
	public String getDate() 
	{
		return date; 
	}
	
	/**
	 * returns the purchase amount of the transaction
	 * @return the purchase amount of the transaction
	 */
	public double getPurchaseAmount() 
	{
		return purchaseAmount; 
	}
	
	/**
	 * returns the transaction ID of the transaction
	 * @return the transaction ID of the transaction
	 */
	public String getTransactionId() 
	{
		return transactionId; 
	}
	
	/**
	 * returns the vendor where the transaction happened
	 * @return the vendor where the transaction happened
	 */
	public String getVendor() 
	{
		return vendor; 
	}

	@Override
	public String toString() 
	{
		return "Transaction [cardNumber=" + cardNumber + ", transactionId=" 
				+ transactionId + ", date=" + date + ", vendor=" + vendor 
				+ ", purchaseAmount=" + purchaseAmount + "]"; 
	}//end of Transaction toString()
}//end of Transaction class
