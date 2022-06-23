/**
 * This is a subclass of CreditCard of type CorporateCard objects
 * that defines the creditLimit, overdraft, monthlyRebateRate.
 * @author tyler
 */
public class CorporateCard extends CreditCard
{
	//class data/variable: one copy for the whole class
	static int countCorporateCards; 
	
	/**
	 * constructor on type Corporate Card and sets the Credit limit to 5000,
	 * overdraft to 2000 and monthly rebate rate to .05 and counts the
	 * total amount of corporate cards
	 * @param cardNumber card number of the card
	 * @param nameOnCard name on the credit card
	 * @param typeOfCard whether it is gold, platinum, or corporate
	 * @param currentBalance current balance on the credit card
	 */
	public CorporateCard(String cardNumber, String nameOnCard, 
			String typeOfCard, double currentBalance)
	{
		super(cardNumber, nameOnCard, typeOfCard, currentBalance); 
		creditLimit = 5000; 
		overdraft = 2000; 
		monthlyRebateRate = 0.05; 
		countCorporateCards++; 
	}//end of CorporateCard constructor
}//end of CorporateCard class