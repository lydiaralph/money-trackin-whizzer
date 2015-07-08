package restapi.interactions;

import java.util.List;

/** 
 * Check whether tags ALREADY exist for transactions in db
 * Check whether matching record already exists in db
 * @author lydia
 *
 */

public class TransactionValidator {

	public static boolean validateTags(String tagToFind){
		List<String> tags = MoneyTrackerInteractor.getRest("getTags");

		for(String tag: tags) {
			System.out.println("Comparing " + tagToFind + " to " + tag);
			if(tag.matches(tagToFind)){
	
				return true;
			}
		}
		return false;
	}
	
	public static boolean validateRecordNotDuplicate(){

		List<String> interactions = MoneyTrackerInteractor.getRest(new ListTransactions().buildHttpRequest());

		System.out.println(interactions);
		
//		for(String tag: tags) {
//			System.out.println("Comparing " + tagToFind + " to " + tag);
//			if(tag.matches(tagToFind)){
//	
				return true;
//			}
//		}
//		return false;
	}

}
