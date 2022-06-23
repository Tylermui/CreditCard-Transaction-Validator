/**
 * This is a subclass of Transactions of type DeniedTransaction objects
 * that is a transaction but has a reason for denial
 * @author tyler
 */
public class DeniedTransaction extends Transactions
{
	//variables of each denied transaction
	private String reasonOfDenial; 
	//class data/variable: one copy for the whole class
	static int countDeniedTransactions; 
	
	/**
	 * creates a new DeniedTransaction object with the information
	 * of the given transaction
	 * @param cardNumber the card number of the transaction
	 * @param transactionId the number of transaction
	 * @param date the date of the transaction
	 * @param vendor the place where the transaction happened
	 * @param purchaseAmount the amount spent on the transaction
	 */
	DeniedTransaction(String cardNumber, String transactionId, String date,
			String vendor, double purchaseAmount)
	{
		super(cardNumber, transactionId, date, vendor, purchaseAmount); 
		countDeniedTransactions++; 
	}

	/**
	 * returns the reason of the denied card
	 * @return the reason of the denied card
	 */
	public String getReasonOfDenial() 
	{
		return reasonOfDenial; 
	}

	/**
	 * gets and sets the reason of denial once it is found
	 * @param reasonOfDenial is the reason for a denied transaction
	 */
	public void setReasonOfDenial(String reasonOfDenial) 
	{
		this.reasonOfDenial = reasonOfDenial; 
	}
	
	@Override
	public String toString() 
	{
		return "DeniedTransaction [reasonOfDenial=" + reasonOfDenial 
				+ ", cardNumber=" + getCardNumber()
				+ ", transactionId=" + getTransactionId() + ", date=" 
				+ getDate() + ", vendor=" + getVendor()
				+", purchaseAmount=" + getPurchaseAmount() +"]"; 
	}//end of DeniedTransaction toString()
}//end of DeniedTransaction class