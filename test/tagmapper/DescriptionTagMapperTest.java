package config;

import tagmapper.*;

public class DescriptionTagMapperTest {
	public static void main(String[] args){
		
		String description = "T";
		String tag = "household";
		
		DescriptionTagMapper dtm = new DescriptionTagMapper();
		
		System.out.println("Tag associated with " + description + ": " 
		+ dtm.getTagFromDescription(description));
		
//		System.out.println("Descriptions associated with tag \" " + tag + "\": " 
//		+ dtm.getDescriptionFromTag(tag));
		
	}

}
