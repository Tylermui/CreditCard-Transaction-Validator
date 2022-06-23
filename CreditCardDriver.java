import java.io.*;
import java.util.*;

/**
 * COPYRIGHT (C) 2022 CreditCardDriver. All Rights Reserved.
 * Classes to manipulate widgets.
 * Solves CS202 homework assignment #2
 * @author Tyler Mui
 * @version 1.01 2022-03-31
 */
/**
 * The purpose of the project is to read in the file "input_creditCards"
 * into an ArrayList and file "input_transaction" into an ArrayList and 
 * see whether or not a transaction is valid or not. If it is not, then 
 * it will show the reason for denial, but if it is, then it will show a
 * successful transaction. Then it will print a list of overdrawn credit 
 * cards if they satisfy the overdrawn status.
 */
public class CreditCardDriver 
{
	public static void main(String[] args) throws IOException
	{
		ArrayList<CreditCard> listCreditCards = new ArrayList<CreditCard>(); 
		//Read data from a given file into an ArrayList of CreditCard.
		listCreditCards = readCardInfo("input_creditCards"); 
		ArrayList<Transactions> listTransactions = new ArrayList<Transactions>(); 
		//Read data from a given file into an ArrayList of Transactions.
		listTransactions = readTransactions("input_transactions"); 
        //check all of the transactions and see if they are denied 
		//or successful and then print them
		sortAndPrintTransaction(listTransactions, listCreditCards); 
		//print overdrawn Cards
		printOverdrawnCards(listCreditCards); 
	}// end main()
	
	/**
	 * Checks the current transaction and if it can process if there
	 * is enough credit or if there is an overdraft and sorts them
	 * to denied or successful transactions
	 * @param transactionAmount the cost of the purchase 
	 * @param listCreditCards ArrayList of CreditCards
	 * @param eachTransaction the specified transaction
	 * @param DeniedTransactionsLocal empty ArrayList of type DeniedTransaction
	 * @param SuccessfulTransactions empty ArrayList of type 
	 * SuccessfulTransaction
	 */
    public static void checkCredit(double transactionAmount,
    		ArrayList<CreditCard> listCreditCards,
    		Transactions eachTransaction,  
    		ArrayList<DeniedTransaction> DeniedTransactionsLocal,
    		ArrayList<SuccessfulTransaction> SuccessfulTransactions)
    {
    	for (CreditCard eachCard: listCreditCards)
		{
    		if (eachCard.getCardNumber().equals(eachTransaction.getCardNumber()))
    		{
    			eachCard.setCurrentBalance(transactionAmount);
    			if ((eachCard.getCreditLimit() + eachCard.getOverdraft()) 
    					< eachCard.getCurrentBalance())
    			{
    				DeniedTransaction newDenial = new DeniedTransaction(
        					eachTransaction.getCardNumber(),
        					eachTransaction.getTransactionId(),
        					eachTransaction.getDate(),
        					eachTransaction.getVendor(),
        					eachTransaction.getPurchaseAmount()); 
    				if (eachCard instanceof GoldCard)
    				{
    					newDenial.setReasonOfDenial("Card credit limit is exceeded!"); 
    				}
    				else
    				{
    					newDenial.setReasonOfDenial("Card overdraft limit is exceeded!"); 
    				}
        			DeniedTransactionsLocal.add(newDenial); 
        			eachCard.setCurrentBalance(-transactionAmount); 
    			}
    			else if (eachCard.getCurrentBalance() 
    					<= eachCard.getCreditLimit())
    			{
    				SuccessfulTransaction newSuccessful = new SuccessfulTransaction(
    						eachTransaction.getCardNumber(),
        					eachTransaction.getTransactionId(),
        					eachTransaction.getDate(),
        					eachTransaction.getVendor(),
        					eachTransaction.getPurchaseAmount());
    				eachCard.setTotalMonthlySpending(transactionAmount); 
    				SuccessfulTransactions.add(newSuccessful); 
    			}
    			else if (eachCard.getCurrentBalance() 
    					<= (eachCard.getCreditLimit() 
    							+ eachCard.getOverdraft()))
    			{
    				SuccessfulTransaction newSuccessful = new SuccessfulTransaction(
    						eachTransaction.getCardNumber(),
        					eachTransaction.getTransactionId(),
        					eachTransaction.getDate(),
        					eachTransaction.getVendor(),
        					eachTransaction.getPurchaseAmount()); 
    				eachCard.setOverdrawnStatus(); 
    				eachCard.setTotalMonthlySpending(transactionAmount); 
    				SuccessfulTransactions.add(newSuccessful); 
    			}
    		}
		}
    }//end of checkCredit()
    
    /**
     * takes in an integer and returns it if it is less than 9,
     * if it is not, then it will add each digit and then return it
     * @param number even place from the card number
     * @return the number of the even place after the algorithm runs
     */
    public static int getDigit(int number)
    {
        if (number < 9)
        {
            return number; 
        }
        return number / 10 + number % 10; 
    }//end of getDigit()    
    
    /**
     * Prints all of the denied transactions
     * @param listDeniedTransactions ArrayList of all Denied Transactions
     */
    public static void printDeniedTransactions(ArrayList<DeniedTransaction> listDeniedTransactions)
    {
    	System.out.println("\n----- List of " 
    			+ DeniedTransaction.countDeniedTransactions 
    			+ " Denied Transactions -----"); 
    	for (DeniedTransaction eachTransaction: listDeniedTransactions)
    	{
    		System.out.println(eachTransaction); 
    	}
    }//end of printDeniedTransactions()
    
    /**
     * finds and prints all of the overdrawn credit cards
     * @param listCreditCards list of all credit cards
     */
    public static void printOverdrawnCards(ArrayList<CreditCard> listCreditCards)
    {
    	ArrayList<OverdrawnCreditCard> overdrawnList = new ArrayList<OverdrawnCreditCard>(); 
    	for (CreditCard eachCard: listCreditCards)
    	{
    		if (eachCard.getOverdrawnStatus()) 
    		{
    			OverdrawnCreditCard newOverdrawn = new OverdrawnCreditCard(
    					eachCard.getCardNumber(),
    					eachCard.getNameOnCard(),
    					eachCard.getTypeOfCard(),
    					eachCard.getCurrentBalance(),
    					eachCard.getCreditLimit(),
    					eachCard.getMonthlyRebateRate(),
    					eachCard.getOverdraft(),
    					eachCard.getOverdrawnStatus(),
    					eachCard.getTotalMonthlySpending()); 
    			overdrawnList.add(newOverdrawn); 
    		}
    	}
    	System.out.println("\n----- List of Overdrawn credit cards -----"); 
    	for (OverdrawnCreditCard eachCard: overdrawnList)
    	{
        	System.out.println(eachCard); 
    	}
    }//end of printOverdrawnCards()
    
    /**
     * Prints all of the successful transactions
     * @param listSuccessfulTransactions ArrayList of all successful transactions
     */
    public static void printSuccessfulTransactions(ArrayList<SuccessfulTransaction> listSuccessfulTransactions)
    {
    	System.out.println("\n----- List of " 
    			+ SuccessfulTransaction.countSuccessfulTransaction 
    			+ " Successful Transactions -----"); 
    	for (SuccessfulTransaction eachTransaction: listSuccessfulTransactions)
    	{
    		System.out.println(eachTransaction); 
    	}
    }//end of printSuccessfulTransactions()
    
	/**
     * This method reads in a dataset of credit card information and returns an ArrayList
     * of CreditCard. 
     * @param fileName all of the raw credit card data
     * @return an ArrayList of CreditCard-type objects
     */
    public static ArrayList<CreditCard> readCardInfo(String fileName) throws IOException
    {
    	final int AMOUNT_OF_CREDITCARDS = 15; 
    	final String Gold = "Gold"; 
    	final String Platinum = "Platinum"; 

        ArrayList<CreditCard> allCreditCardsLocal = new ArrayList<CreditCard>(); 
        Scanner fileReader = new Scanner(new File(fileName)); 
        for (int i = 0; i < AMOUNT_OF_CREDITCARDS; i++)
        {
        	String textOnLine = fileReader.nextLine(); 
        	String[] lineNumber = textOnLine.split(","); 
        	String cardNum = lineNumber[0]; 
        	String name = lineNumber[1]; 
        	String typeOfCard = lineNumber[2]; 
        	double currentBalance = Double.parseDouble(lineNumber[3].substring(1)); 
        	if (typeOfCard.equals(Gold))
        	{
        		GoldCard newGoldCard = new GoldCard(cardNum, name, 
        				typeOfCard, currentBalance); 
            	allCreditCardsLocal.add(newGoldCard); 
        	}//end if statement for gold card
        	else if (typeOfCard.equals(Platinum)) {
        		PlatinumCard newPlatinumCard = new PlatinumCard(cardNum, name,
        				typeOfCard, currentBalance); 
            	allCreditCardsLocal.add(newPlatinumCard); 
        	}//end else if statement for platinum card
        	else
        	{
        		CorporateCard newCorporateCard = new CorporateCard(cardNum, 
        				name, typeOfCard, currentBalance); 
        		allCreditCardsLocal.add(newCorporateCard); 
        	}//end else statement for corporate card
        }//end of for loop
        System.out.println(allCreditCardsLocal.size() + " credit cards are read and stored."); 
        return allCreditCardsLocal; 
    }//end of readCardInfo() 
    
	/**
     * This method reads in a dataset of credit card transactions and returns an ArrayList
     * of Transaction. 
     * @param fileName all of the raw transaction data
     * @return an ArrayList of Transaction-type objects
     */
    public static ArrayList<Transactions> readTransactions(String fileName) throws IOException
    {
    	final int AMOUNT_OF_TRANSACTIONS = 35; 
        ArrayList<Transactions> allTransactionsLocal = new ArrayList<Transactions>(); 
        Scanner fileReader = new Scanner(new File(fileName)); 
        for (int i = 0; i < AMOUNT_OF_TRANSACTIONS; i++)
        {
        	String textOnLine = fileReader.nextLine(); 
        	String[] lineNumber = textOnLine.split(","); 
        	String cardNum = lineNumber[0]; 
        	String transactionID = lineNumber[1]; 
        	String date = lineNumber[2]; 
        	String vendor = lineNumber[3]; 
        	double transactionAmount = Double.parseDouble(lineNumber[4].substring(1)); 
        	Transactions newTransaction = new Transactions(cardNum, 
        			transactionID, date, vendor, transactionAmount); 
        	allTransactionsLocal.add(newTransaction); 
        }//end of for loop
        System.out.println(Transactions.numOfTransactions + " transactions are read and stored."); 
        return allTransactionsLocal; 
    }//end of readCardInfo() 
    
	/**
     * This method reads in an ArrayList of type CreditCard and Transaction and checks 
     * to see if the card numbers match or not and prints them
     * @param listCreditCards ArrayList of all Credit Cards
     * @param listTransactions ArrayList of all transactions
     */
    public static void sortAndPrintTransaction(ArrayList<Transactions> listTransactions,
    		ArrayList<CreditCard> listCreditCards)
    {
        ArrayList<DeniedTransaction> DeniedTransactions = 
        		new ArrayList<DeniedTransaction>(); 
        ArrayList<SuccessfulTransaction> SuccessfulTransactions = 
        		new ArrayList<SuccessfulTransaction>(); 
    	for (Transactions eachTransaction: listTransactions)
    	{
	    	if ((sumOfDoubleEvenPlace(eachTransaction.getCardNumber()) +
	                sumOfOddPlace(eachTransaction.getCardNumber())) % 10 != 0)
	    	{
	    		DeniedTransaction newDenial = new DeniedTransaction(
    					eachTransaction.getCardNumber(),
    					eachTransaction.getTransactionId(),
    					eachTransaction.getDate(),
    					eachTransaction.getVendor(),
    					eachTransaction.getPurchaseAmount()); 
    			newDenial.setReasonOfDenial("Invalid card number!"); 
    			DeniedTransactions.add(newDenial); 
	    	}	    	
	    	if ((sumOfDoubleEvenPlace(eachTransaction.getCardNumber()) +
	                sumOfOddPlace(eachTransaction.getCardNumber())) % 10 == 0)
	    	{
	    		double transactionAmount = eachTransaction.getPurchaseAmount(); 
	    		checkCredit(transactionAmount, listCreditCards, 
	    				eachTransaction, DeniedTransactions, SuccessfulTransactions); 
	    	}
    	}
    	printDeniedTransactions(DeniedTransactions); 
    	printSuccessfulTransactions(SuccessfulTransactions); 
    }//end of sortAndPrintTransaction()
    
    /**
     * gets the even places of the credit card number and adds them
     * @param number the card number on the transaction
     * @return sum of the doubled even places
     */
    public static int sumOfDoubleEvenPlace(String number)
    {
        int sum = 0; 
        String num = number + ""; 
        for (int i = 14; i >= 0; i -= 2)
        {
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2); 
        }
        return sum; 
    }//end of sumOfDoubleEvenPlace()

    /**
     * gets the odd places of the credit card number and adds those numbers
     * @param number the card number on the transaction
     * @return sum of odd-place digits in number
     */
    public static int sumOfOddPlace(String number)
    {
        int sum = 0; 
        String num = number + ""; 
        for (int i = 15; i >= 0; i -= 2)
        {
            sum += Integer.parseInt(num.charAt(i) + ""); 
        }
        return sum; 
    }//end of sumOfOddPlace()
}//end class CreditCardDriver
