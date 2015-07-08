package tagmapper;

import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Looks up tag for record based on description.
 * Config is stored in taglist.properties
 * 
 * @author lydia
 *
 */

public class DescriptionTagMapper {
	// LER TODO: load from properties file
	private static String CONFIG_FILE_PATH;
	private HashMap<String, String> descriptionTagMap = new HashMap<String, String>();

	public DescriptionTagMapper() {
		Properties prop = loadProperties();
		for (String key : prop.stringPropertyNames()) {
			String value = prop.getProperty(key);
			descriptionTagMap.put(key, value);
		}
	}

	public String getTagFromDescription(String description) {
		int found = 0;
		List<String> list = new ArrayList<String>();

		HashMap<String, String> dtm = this.descriptionTagMap;

		for (String key : dtm.keySet()) {
			if (match(description, key)) {
				list.add(this.descriptionTagMap.get(key));
				found++;
				// System.out.println("Found match for " + description + ": " + key);
			}
		}

		if (found == 0) {
			// TODO: log error message: tag not found
			System.out.println("Error: no tags found for " + description + ". Setting tag as 'Unknown'...");
			return "Unknown";
		} else if (found > 1) {
			// TODO: log error message: more than one tag found
			System.out.println("Error: several possible tags found for "
					+ description + ": " + list + ". Setting tag as 'Unknown'...");
			return "Unknown";
		}
		
		return list.get(0);
	}

	public List<String> getDescriptionFromTag(String tag) {
		Set<String> ref = this.descriptionTagMap.keySet();
		Iterator<String> it = ref.iterator();
		List<String> list = new ArrayList<String>();

		while (it.hasNext()) {
			String o = it.next();
			if (this.descriptionTagMap.get(o).equals(tag)) {
				list.add(o);
			}
			it.remove(); // avoids a ConcurrentModificationException
		}
		return list;
	}

	private Properties loadProperties() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			prop.load(new FileInputStream(CONFIG_FILE_PATH));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}

	private boolean match(String text, String key) {
		/** 
		 * This only matches an entire string, i.e. ABC_TESCO_123 will match 'TESCO' but TES_123_CO will not
		 * Note: all non-alphanumeric characters are stripped out
		 */
		String description = text.replaceAll("[^A-Za-z0-9]", "");
		
		// Matches 
		if(description.toLowerCase().contains(key.toLowerCase())){
			return true;
		}
		else if(key.toLowerCase().contains(description.toLowerCase())){
			return true;
		}
		else if(description.matches(key.replace("?", ".?").replace("*", ".*?"))){
			return true;
		}
		return false;
	}
}
