package testpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepkg.Saucepage;
import utilities.Excelutils;

public class Saucetest {

	WebDriver driver;
	String baseurl="https://www.saucedemo.com/";
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void test1() throws Exception
	{
		Saucepage ob=new Saucepage(driver);
		String xl="C:\\Users\\hp admin\\OneDrive\\Documents\\Book 17.xlsx";
		String sheet="Sheet1";
		int rowcount=Excelutils.getrowcount(xl, sheet);
		for(int i=1;i<=rowcount;i++)
		{
			String username=Excelutils.getcellvalues(xl, sheet, i, 0);
			System.out.println("Username="+username);
			String password=Excelutils.getcellvalues(xl, sheet, i, 1);
			System.out.println("Password="+password);
			ob.setvalues(username, password);
			ob.loginclick();
			
		}
		
		ob.cart();
	    ob.addcart();
		ob.details("Agna", "Antony", 758496);
		ob.contimthd();
		ob.logout();
		
	}

	
}
