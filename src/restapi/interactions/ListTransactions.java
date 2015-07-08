package restapi.interactions;

import java.time.LocalDate;

/**
 * REST API call: listTransactions
 * Returns a list with all the transactions inserted by the user within the given dates.

 * Arguments
 * project   - ID of the project (returned in function <a href="/help/API/listProjects">listProjects</a>). 
 *                            Specify an empty string to reference the main account
 * startDate - Start date (ISO 9601 format - YYYY-MM-DD)
 * endDate   - End date (ISO 9601 format - YYYY-MM-DD)
 * @author lydia
 *
 */

public class ListTransactions {
	public String buildHttpRequest(){
		String httpRequestBuilder;
		httpRequestBuilder = "listTransactions?";
		
		httpRequestBuilder += "project=";
		
		httpRequestBuilder += "&startDate=";
		httpRequestBuilder += LocalDate.of(2010, 01, 01);
		
		httpRequestBuilder += "&endDate=";
		httpRequestBuilder += LocalDate.now();
		
		System.out.println("HTTP Request: " + httpRequestBuilder);
		
		return httpRequestBuilder;
	}
}
