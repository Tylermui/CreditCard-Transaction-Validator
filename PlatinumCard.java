/**
 * This is a subclass of CreditCard of type PlatinumCard objects
 * that defines the creditLimit, overdraft, monthlyRebateRate.
 * @author tyler
 */
public class PlatinumCard extends CreditCard
{
	//class data/variable: one copy for the whole class
	static int countPlatinumCards; 
	
	/**
	 * constructor on type Platinum Card and sets the Credit limit to 3000,
	 * overdraft to 1000 and monthly rebate rate to .02 and counts the
	 * total amount of platinum cards
	 * @param cardNumber card number of the card
	 * @param nameOnCard name on the credit card
	 * @param typeOfCard whether it is gold, platinum, or corporate
	 * @param currentBalance current balance on the credit card
	 */
	public PlatinumCard(String cardNumber, String nameOnCard, 
			String typeOfCard, double currentBalance)
	{
		super(cardNumber, nameOnCard, typeOfCard, currentBalance); 
		creditLimit = 3000; 
		overdraft = 1000; 
		monthlyRebateRate = 0.02; 
		countPlatinumCards++; 
	}//end of PlatinumCard constructor
}//end of PlatinumCard Class