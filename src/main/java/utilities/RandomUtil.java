package utilities;
import java.util.ArrayList;
import java.util.Random;

import com.tinyServer.data.ManagerData;
import com.tinyServer.data.UserData;

public class RandomUtil {
	
	public static String getRandomEmail() {
		Random rand = new Random();
		return "tester" + rand.nextInt(99999) + "@gmail.com";
	}
	
	public static String getRandomPhoneNumber() {
		Random rand = new Random();
		return "012" + (1000000 + rand.nextInt(9999999));
	}
	
	public static String getRandomName() {
		Random rand = new Random();
		return "AutoTest" + rand.nextInt(9999);
	}
	
	public static String getRandomPassword() {
		Random rand = new Random();
		return "Password" + rand.nextInt(99999);
	}
	
	public static String getRandomString(int length) {
		Random rand = new Random();
		String randomString = "";
		for (int i = 0; i < length; i++) {
			if (rand.nextBoolean())
				randomString += (char) (rand.nextInt(122 - 97) + 97);
			else
				randomString += (char) (rand.nextInt(90 - 65) + 65);
		}
		return randomString;
	}
	
	public static ManagerData getRandomManagerData() {
		Random rand = new Random();
		
		String email = getRandomEmail();
		String password = getRandomPassword();
		String company = "CTY " + getRandomString(3);
		String fullname = getRandomName();
		String employeesNumber = String.valueOf(rand.nextInt(99));
		String phone = getRandomPhoneNumber();
		return new ManagerData(email,password,company,fullname,employeesNumber,phone);
	}
	
	public static UserData getRandomUserData() {
		
		String startDate = DateUtil.addDayToCurrentDay(3);
		String fname = getRandomString(5);
		String lname = getRandomString(5);
		String email = getRandomEmail();
	
		return new UserData(fname,lname,email,startDate);
	}
	
	public static ArrayList<UserData> getRandomUserList(int numberOfUser){
		ArrayList<UserData> userList = new ArrayList<UserData>();
		
		for(int i = 1;i<=numberOfUser;i++) {
			userList.add(getRandomUserData());
		}
		
		return userList;
	}
}
