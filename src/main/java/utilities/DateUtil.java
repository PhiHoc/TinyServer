package utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

public class DateUtil {
	
	public static String getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_MONTH);
        return Integer.toString(today);
    }
	
	public static String addDayToCurrentDay(int days) {
		//get current day
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		
		//add day to current day
		cal.add(Calendar.DAY_OF_MONTH, days);
		
		//change calendar to string with YMD format
		String month;
		int monthInt = cal.get(Calendar.MONTH)+1;
		if (monthInt < 10)
			month = "0" + monthInt;
		else
			month = Integer.toString(monthInt);
		String ymd = String.format("%s-%s-%s",cal.get(Calendar.YEAR),month, cal.get(Calendar.DAY_OF_MONTH));
		return ymd;
	}
	
	public static void selectDatePicker(List<WebElement> elementList, String ymd) {
		for (WebElement element : elementList) {
					System.out.println("current: " + ymd);
		            String text = element.getAttribute("data-value");
		            System.out.println(text);
		            if (text.contains(ymd)) {
		            	element.click();
		                break;
		            }
		        }
	}		
}
