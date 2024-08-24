package utility;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtility 
{
	public static String generateDate() 
	{
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy_HHmmss");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
	
}
