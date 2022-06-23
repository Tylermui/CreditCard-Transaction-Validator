/**
 * This is a subclass of CreditCard of type OverdrawnCreditCard objects
 * that creates a new overdrawn card with the given card information and
 * returns that information in a toString statement.
 * @author tyler
 */
public class OverdrawnCreditCard extends CreditCard
{	
	/**
	 * constructor on type OverdrawnCreditCard and gets the information
	 * of the selected card that overdrawn status is true
	 * @param cardNumber number on the card
	 * @param nameOnCard name holder on the card
	 * @param typeOfCard the type of card: gold, platinum, or corporate
	 * @param currentBalance the current balance on the card
	 * @param creditLimit the credit limit on the card: 1000, 2000, or 5000
	 * @param monthlyRebateRate the rebate of the card: .01, .02, or .05
	 * @param overdraft the overdraft limit of the card: 1000, 2000
	 * @param overdrawnStatus the overdrawn status that must be true
	 * @param totalMonthlySpending the total monthly spending amount
	 */
	OverdrawnCreditCard(String cardNumber, String nameOnCard, String typeOfCard,
			double currentBalance, int creditLimit, double monthlyRebateRate,
			int overdraft, boolean overdrawnStatus, double totalMonthlySpending)
	{
		super(cardNumber, nameOnCard, typeOfCard, currentBalance); 
		this.creditLimit = creditLimit; 
		this.monthlyRebateRate = monthlyRebateRate; 
		this.overdraft = overdraft; 
		this.overdrawnStatus = overdrawnStatus; 
		this.totalMonthlySpending = totalMonthlySpending; 
	}//end of OverdrawnCreditCard constructor

	@Override
	public String toString() 
	{
		return  getTypeOfCard() + " [cardNumber=" + getCardNumber() 
				+ ", holderName=" + getNameOnCard() 
				+ ", creditLimit=" + getCreditLimit() 
				+ ", rebateRate=" + getMonthlyRebateRate() 
				+ ", overdraftLimit=" + getOverdraft() 
				+ ", balance=" + getCurrentBalance() 
				+ ", total monthly purchase=" + getTotalMonthlySpending()
				+ ", total montlhy rebate=" + (getTotalMonthlySpending() 
						* getMonthlyRebateRate())
				+ ", overdrawnStatus=" + getOverdrawnStatus() + "]"; 
	}// end of OverdrawnCreditCard toString()
}//end of OverdrawnCreditCard class