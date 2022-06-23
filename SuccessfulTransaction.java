/**
 * This is a subclass of Transactions of type SuccessfulTransaction objects
 * that returns a transaction if there is not a reason for denial
 * @author tyler
 */
public class SuccessfulTransaction extends Transactions 
{
	//class data/variable: one copy for the whole class
	static int countSuccessfulTransaction; 
	
	/**
	 * creates a new SuccessfulTransaction object and counts how many there are
	 * @param cardNumber the card number of the transaction
	 * @param transactionId the number of transaction
	 * @param date date of the transaction
	 * @param vendor where the transaction was made
	 * @param purchaseAmount the amount that was charge on the transaction
	 */
	SuccessfulTransaction(String cardNumber, String transactionId, String date,
			String vendor, double purchaseAmount) 
	{
		super(cardNumber, transactionId, date, vendor, purchaseAmount); 
		countSuccessfulTransaction++; 
	}

	@Override
	public String toString() 
	{
		return super.toString(); 
	}//end of SuccessfulTransaction toString()
}//end of SuccessfulTransaction class