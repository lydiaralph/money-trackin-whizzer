package restapi.interactions;

/**
 * REST API call: GetBalance
 * Returns a list of all the projects/accounts created by the user, plus balance figures
 * 
 * Arguments
 * No arguments
 *
 * @author lydia
 *
 */

public class GetBalanceTest {
	
	// TODO: change to not-main
	public static void main(String[] args){
		try{
//			MoneyTrackerInteractor.getRest("listProjects");
//			MoneyTrackerInteractor.getRest("getBalance");
			MoneyTrackerInteractor.getRest("getTags");
		}
		catch(Exception e){
			System.out.println("Could not insert transaction: " + e);
		}	
	}
}
