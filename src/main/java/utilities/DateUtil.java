package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DateUtil {

	public static String getCurrentDay() {
		LocalDate lt = LocalDate.now();
		return lt.toString();
	}

	public static String getCurrentDayBefore(int days) {
		LocalDate lt = LocalDate.now();
		lt.minusDays(days);
		return lt.minusDays(days).toString();
	}

	public static String getCurrentDayAfter(int days) {
		LocalDate lt = LocalDate.now();
		lt.minusDays(days);
		return lt.plusDays(days).toString();
	}

	public static int stringMonthToInt(String monthStr) throws ParseException {
		Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(monthStr);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int monthInt = cal.get(Calendar.MONTH) + 1;
		return monthInt;
	}

	public static void selectDatePicker(WebDriver driver,String elementList, WebElement nextLink, WebElement previousLink,
			WebElement monthYear, String ymd) {
		String expMonth = ymd.split("-")[1];
		String expYear = ymd.split("-")[0];

		while (true) {
			String currMonth = monthYear.getText().split("\\r?\\n")[0];
			String currYear = monthYear.getText().split("\\r?\\n")[1];
			try {
				System.out.println(currMonth+ " - " +expMonth);
				int monthDiff = stringMonthToInt(currMonth) - Integer.parseInt(expMonth);
				int yearDiff = Integer.parseInt(currYear) - Integer.parseInt(expYear);

				// Click until get the right year first
				if (yearDiff == 0) {
					// Then click to get the right month
					if (monthDiff < 0)
						nextLink.click();
					else if (monthDiff > 0)
						previousLink.click();
					else
						break;
				} else if (yearDiff > 0)
					previousLink.click();
				else
					nextLink.click();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		List<WebElement> dayList = driver.findElements(By.xpath(elementList));
		for (WebElement element : dayList) {
			String text = element.getAttribute("data-value");
			//System.out.println(text);
			if (text.contains(ymd)) {
				element.click();
				break;
			}
		}
	}

	public static void main(String[] args) {

		try {

			System.out.println(stringMonthToInt("May"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
