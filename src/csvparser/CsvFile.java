package csvparser;


import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.*;

import restapi.interactions.*;

/**
 * Reads CSV File and analyses each record
 * 
 * Returns List of IndividualTransactions: date, description, amount and tag 
 * 
 * @author lydia.ralph
 *
 */

public class CsvFile{
	public static List<IndividualTransaction> readCsvFileReturnBatch(String filePath, String fileName){
		List<IndividualTransaction> list = new ArrayList<IndividualTransaction>();
		
		try (Reader in = new FileReader(filePath)){
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
			
			for (CSVRecord record : records) {
				IndividualTransaction it = new IndividualTransaction();
				it.setDate(record.get("Date"));
				it.setDescription(record.get("Description"));
				it.setTag(it.getDescription());
				it.setAmount(record.get("Amount"));
				
				list.add(it);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Could not read file: " + e);
		}
		catch(IOException e){
			System.out.println("Could not parse file" + e);
		}
		return list;
	}
	

}