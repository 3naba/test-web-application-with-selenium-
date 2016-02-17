package testselinum;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import testselinum.excel;

public class chrome {


 
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
    @Before
  public void setUp() throws Exception { 
    	System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
          driver = new ChromeDriver();
   // driver = new FirefoxDriver(); 
    baseUrl = "http://codeforces.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test4() throws Exception {
	  
	  int choice=0;
	  System.out.println("1 test success log in  ");
	  System.out.println("2 test fail  log in  ");
	  System.out.println("enter your choice ");
	  Scanner in = new Scanner(System.in);
	  choice= in.nextInt();
	  String pass = "";
	  String username = "";
	  if(choice == 1){
	  
		   excel  d  =  new excel ("C:\\Users\\ahmed\\Desktop\\book12.xlsx", "Ê—ﬁ…1");
	   
	   username= d.getCellDataasstring(0, 0); 
	   System.out.print(username);
	   pass= d.getCellDataasstring(1, 0);
	   System.out.println(pass);
	   
	 
	  
	  }
	  else{
		   excel  d  =  new excel ("C:\\Users\\ahmed\\Desktop\\book12.xlsx", "Ê—ﬁ…1");
		   pass= d.getCellDataasstring(2, 0);
		   username= d.getCellDataasstring(3, 0); 
		  
	  }
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Enter")).click();
    driver.findElement(By.id("handle")).clear();
    driver.findElement(By.id("handle")).sendKeys(username);
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys( pass );
    driver.findElement(By.cssSelector("input.submit")).click();
    Thread.sleep(10000);
    String title=driver.getTitle();
	System.out.println(title);
    assertEquals(title, "Codeforces");
  }

   

}
