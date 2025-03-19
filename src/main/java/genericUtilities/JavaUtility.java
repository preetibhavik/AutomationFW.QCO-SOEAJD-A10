package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of generic method related to java
 * @author DELL
 */
public class JavaUtility {
	/**
	 * This method will capture the current system date and return to caller
	 * Used to name screenshots and reports
	 * @return
	 */

	public String getSystemDateInFormat()
	{
		Date d= new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = f.format(d);
		return date;
		
	}
}
