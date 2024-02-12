package Utilities;

import java.util.Date;

public class UniqueNameHelper {

	// To return the time stamp so that it can be used in naming screenshot and html
	// reporter files
	public static String getTimeStamp() {
		Date date = new Date();
		String partialName = date.toString().replaceAll(":", "_").replaceAll(" ", "_");
		return partialName;
	}
}
