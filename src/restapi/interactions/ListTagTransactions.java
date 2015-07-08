package restapi.interactions;

/** 
 * REST API call: listTagTransactions
 * Returns a list with all the transactions inserted by the user tagged with the specified tag.
 * 
 * Arguments
 * project   - ID of the project (returned in function listProjects). 
 *                                Specify an empty string to reference the main account
 * tag       - Tag to search
 * startDate - Start date (ISO 9601 format - YYYY-MM-DD)
 * endDate   - End date (ISO 9601 format - YYYY-MM-DD)
 */

public class ListTagTransactions extends ListTransactions{

}
