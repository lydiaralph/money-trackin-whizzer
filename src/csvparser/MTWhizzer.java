package csvparser;

import java.util.List;

import restapi.interactions.*;

/** 
 * Designed as main program
 * TODO: tidy it up
 * @author lydia.ralph
 *
 */

public class MTWhizzer {
	// LER TODO: load this from buildinfo.properties file
	private static String defaultCsvFilePath; 
	
	public static void main(String[] args) {
		// To be updated as necessary
		String currentlyRecognisedTransactions = "Recognised transactions include "
				+ "getBalance, getTags, insertTransaction (+ CSV File)";
		
		if (args.length == 0) {
			System.out.println("No arguments! please enter what you want MTWhizzer to do."); 
			System.out.println(currentlyRecognisedTransactions);
			return;
		}
		
		switch(args[0]){
		/// No-arg requests
		case "listProjects":
		case "getTags":
		case "getBalance":
			try{
				MoneyTrackerInteractor.getRest(args[0]);
			}
			catch(Exception e){
				System.out.println("Error: " + e);
			}
			break;

		case "insertTransaction":
			
			// TODO: accept CSV file name from cmd line
//			if(args.length < 1 ){
//				System.out.println("Expected a CSV file to be entered as second arg");
//				return;
//			}
//			else{
//				String fileName = args[1];
//			}
			String fileName = "20150418_61307800.CSV";
			String filePath = defaultCsvFilePath + fileName;
			
			// TODO: check validity of CSV file, or catch exception if unable to parse it
							
			List<IndividualTransaction> list = CsvFile.readCsvFileReturnBatch(filePath, fileName);
				
			// Insert each transaction into DB
			// TODO: check for duplicate records
			// TODO: check for valid tags
		    for(IndividualTransaction it : list) {
		       	//MoneyTrackerInteractor.getRest(it.buildHttpRequest());
		    }
		    
		    
			break;


		default:
			System.out.println("Unexpected request.\n" + currentlyRecognisedTransactions);
			return;
		}

	}

}


