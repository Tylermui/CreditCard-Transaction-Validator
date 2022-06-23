/**
 * This is a subclass of CreditCard of type GoldCard objects
 * that defines the creditLimit, overdraft, monthlyRebateRate.
 * @author tyler
 */
public class GoldCard extends CreditCard
{
	//class data/variable: one copy for the whole class
	static int countGoldCards; 
	
	/**
	 * constructor on type GoldCard and sets the Credit limit to 1000,
	 * overdraft to 0 and monthly rebate rate to .01 and counts the
	 * total amount of gold cards
	 * @param cardNumber card number of the card
	 * @param nameOnCard name on the credit card
	 * @param typeOfCard whether it is gold, platinum, or corporate
	 * @param currentBalance current balance on the credit card
	 */
	public GoldCard(String cardNumber, String nameOnCard, 
			String typeOfCard, double currentBalance)
	{
		super(cardNumber, nameOnCard, typeOfCard, currentBalance); 
		creditLimit = 1000; 
		overdraft = 0; 
		monthlyRebateRate = 0.01; 
		countGoldCards++; 
	}//end of GoldCard constructor
}//end of GoldCard Class