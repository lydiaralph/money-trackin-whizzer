package restapi.interactions;

import restapi.interactions.*;

public class IndividualTransactionTest {
	public static void main(String[] args){
		IndividualTransaction it = new IndividualTransaction();
		
		it.setProject("133228");
		it.setDescription("testDescription");
		it.setAmount("00.50");
		it.setDate("27/01/2015");
		it.setTag(it.getDescription());
		
		System.out.println(it.buildHttpRequest());
		
		try{
			MoneyTrackerInteractor.getRest(it.buildHttpRequest());
		}
		catch(Exception e){
			System.out.println("Could not insert transaction: " + e);
		}
	}
}
