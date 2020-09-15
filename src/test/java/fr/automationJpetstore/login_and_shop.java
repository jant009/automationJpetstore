package fr.automationJpetstore;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class login_and_shop {
	
	public static int getRandomNumberInts(int min, int max){

	    Random random = new Random();

	    return random.ints(min,(max+1)).findFirst().getAsInt();

	}
	int random_int = login_and_shop.getRandomNumberInts(1, 55555);
	String username = "test" + random_int;
	
	
	WebDriver driver;
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
		
	@Test
	public void test() {
		
	System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
	driver = new FirefoxDriver();
	
	//CONFIGURATION D'UN IMPLICIT WAIT

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	//navigation
	
	driver.get("http://localhost:8093/jpetstore");
	
	driver.findElement(By.xpath("//a[.='Enter the Store']")).click();
		
	driver.findElement(By.xpath("//a[text()='Sign In']")).click();
	
	// Rempli les champs login password
	WebElement champ_login = driver.findElement(By.name("username"));
	champ_login.clear();
	champ_login.sendKeys("ACID");
	
	WebElement champ_pwd = driver.findElement(By.name("password"));
	champ_pwd.clear();
	champ_pwd.sendKeys("ACID");
	
	//clic sur le bouton submit
	driver.findElement(By.name("signon")).click();
	
	//verification du message de bienvenue

	assertEquals(driver.findElement(By.id("WelcomeContent")).getText(),"Welcome ABC!");
	
	//Achat reptile
	driver.findElement(By.xpath("//img[contains(@src,'reptiles_icon.gif')]")).click();
	
	driver.findElement(By.xpath("//td[text()='Iguana']/preceding-sibling::td")).click();
	
	driver.findElement(By.xpath("//a[text()='Add to Cart']")).click();
	
	//doubler la quantité du produit

	driver.findElement(By.xpath("//input[@name='EST-13']")).clear();

	driver.findElement(By.xpath("//input[@name='EST-13']")).sendKeys("2");

	driver.findElement(By.xpath("//input[contains(@name,'update')]")).click();
	
	//retour main menu
	
	driver.findElement(By.xpath("//a[text()='Return to Main Menu']")).click();
	
	//changer parametre my account
	driver.findElement(By.xpath("//a[text()='My Account']")).click();
	
	driver.findElement(By.xpath("//input[@name='account.listOption']")).click();
	
	driver.findElement(By.xpath("//input[@name='editAccount']")).click();
	
	//recherche
	WebElement search = driver.findElement(By.xpath("//input[@name='keyword']"));
	search.clear();
	search.sendKeys("fish");
	
	driver.findElement(By.xpath("//input[@name='searchProducts']")).click();
	
	//verification recherche

	assertEquals(driver.findElement(By.xpath("//td[3]")).getText(),"Goldfish");
	
	//Achat fish
	driver.findElement(By.xpath("//td/a")).click();
	
	driver.findElement(By.xpath("//a[text()='Add to Cart']")).click();
	
	//Achat dogs
	driver.findElement(By.xpath("//img[contains(@src,'sm_dogs.gif')]")).click();
	
	driver.findElement(By.xpath("//td[text()='Poodle']/preceding-sibling::td")).click();
	
	driver.findElement(By.xpath("//a[text()='Add to Cart']")).click();
	
	
	
	//Achat birds
	driver.findElement(By.xpath("//img[contains(@src,'sm_birds.gif')]")).click();
			
	driver.findElement(By.xpath("//td[text()='Finch']/preceding-sibling::td")).click();
			
	driver.findElement(By.xpath("//a[text()='Add to Cart']")).click();
	
	
	//shopping cart proceed
	
	driver.findElement(By.xpath("//a[text()='Proceed to Checkout']")).click();

	driver.findElement(By.xpath("//input[@name='newOrder']")).click();
	
	driver.findElement(By.xpath("//a[text()='Confirm']")).click();
	
	driver.findElement(By.xpath("//a[text()='Return to Main Menu']")).click();
	
	//sign out
	
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	//new account
	
	driver.findElement(By.xpath("//a[text()='Sign In']")).click();
	
	driver.findElement(By.xpath("//a[text()='Register Now!']")).click();
	
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
	
	driver.findElement(By.xpath("//input[@name='repeatedPassword']")).sendKeys("12345");
	
	driver.findElement(By.xpath("//input[@name='account.firstName']")).sendKeys("yes");
	
	driver.findElement(By.xpath("//input[@name='account.lastName']")).sendKeys("yes");

	driver.findElement(By.xpath("//input[@name='account.email']")).sendKeys("yes");

	driver.findElement(By.xpath("//input[@name='account.phone']")).sendKeys("yes");

	driver.findElement(By.xpath("//input[@name='account.address1']")).sendKeys("yes");
	
	driver.findElement(By.xpath("//input[@name='account.city']")).sendKeys("yes");

	driver.findElement(By.xpath("//input[@name='account.state']")).sendKeys("yes");

	driver.findElement(By.xpath("//input[@name='account.zip']")).sendKeys("yes");

	driver.findElement(By.xpath("//input[@name='account.country']")).sendKeys("yes");
	
	driver.findElement(By.xpath("//input[@name='newAccount']")).click();
	
	System.out.println("FINISH");
	}
}
