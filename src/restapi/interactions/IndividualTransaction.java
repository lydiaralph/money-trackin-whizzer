package restapi.interactions;

/** 
 * REST API call: insertTransaction
 * Create a new transaction and insert into MoneyTracker
 * 
 * project     - ID of the project (returned in function listProjects). 
                                 Specify an empty string to reference the main account
 * description - Transaction's description
 * amount      - Transaction's amount (e.g: 12.33 -129.7)
 * date        - Transaction date in ISO 9601 format (YYYY-MM-DD). leave empty for the current date
 * tag        - Transaction's tag alphanumeric, space separated
 * idperiodic  - Only used on periodic transactions. Leave null for normal ones
*/

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import tagmapper.DescriptionTagMapper;

public class IndividualTransaction{
	private String project;
	private String description;
	private String amount;
	private LocalDate date;
	
	// TODO: May need array of tag at some point. For now, one tag per transaction
	private String tag;
	private String idperiodic;
	
	public String buildHttpRequest(){
		String httpRequestBuilder;
		httpRequestBuilder = "insertTransaction?";
		
		httpRequestBuilder += "project=";
		httpRequestBuilder += this.project;
		
		httpRequestBuilder += "&description=";
		httpRequestBuilder += this.description;
		
		httpRequestBuilder += "&amount=";
		httpRequestBuilder += this.amount;
		
		httpRequestBuilder += "&date=";
		httpRequestBuilder += this.date;
		
		httpRequestBuilder += "&tag=";
		httpRequestBuilder += this.tag;
		
		httpRequestBuilder += "&idperiodic=";
		httpRequestBuilder += this.idperiodic;
		
		return httpRequestBuilder;
	}
	
	//Constructor
	public void InsertTransaction(){
		this.setProject("");
		this.setDescription("");
		this.setTag(this.description);
		this.setAmount("");
		this.date = LocalDate.now();
		this.setIdperiodic("");
	}
	
	
	// SETTERS
	public void setProject(String project){
		this.project = project;
	}
	
	public void setDescription(String description){
		/**
		 *  Remove spaces and illegal characters from Description
		 *  Trim spaces and replace with single %20
		 */				
		this.description = description.replaceAll("[^A-Za-z0-9] ", "").replaceAll("\\s+", " ");
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setTag(String description){
		// TODO: check db to see tag is valid
		this.tag = new DescriptionTagMapper().getTagFromDescription(description);
	}
    
	public String getTag(){
		return this.tag;
	}
	
	public void setAmount(String amount){
		this.amount = amount;
	}
	
	public String getAmount(){
		return this.amount;
	}
	
	public void setDate(String inputDate){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try{
			this.date = LocalDate.parse(inputDate, formatter);
		}
		catch (Exception e){
			System.out.println("Could not parse date: " + e);
		}
	}
	
	public LocalDate getDate(){
		return this.date;
	}
	
	public void setIdperiodic(String idper){
		this.idperiodic = idper;
	}
	
	public String getIdperiodic(){
		return this.idperiodic;
	}
}
