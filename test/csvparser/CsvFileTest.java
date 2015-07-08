package csvparser;

import java.util.List;

import restapi.interactions.IndividualTransaction;

/** 
 * Analyses a CSV file and returns records with description, date, amount and tags
 * @author lydia
 *
 */

public class CsvFileTest {

	public static void main(String[] args) {
		String fileName = "20150418_61307800.CSV";
		String filePath = "/home/lydia/Downloads/" + fileName;
		
		System.out.println("Analysing CSV file....");
		
		List<IndividualTransaction> list = CsvFile.readCsvFileReturnBatch(filePath, fileName);

		System.out.println("Records found: ");
		
        for(IndividualTransaction it : list) {
    		System.out.println("Record: " + it.getDescription() 
		      + "\t Tag: " + it.getTag() 
		      + "\t Date: " + it.getDate()
		      + "\t Amount: " + it.getAmount() );
        }
		
		// Insert transaction
		//MoneyTrackerInteractor.getRest(it.buildHttpRequest());
	}

}
