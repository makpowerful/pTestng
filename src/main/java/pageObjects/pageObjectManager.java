package pageObjects;

import org.openqa.selenium.WebDriver;

public class pageObjectManager {
	
	public WebDriver driver;
	public loginPO loginPO;
	public homePO homePO;
	public eventPO eventPO;
	
	public pageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public loginPO getLoginPage()
	{
		loginPO = new loginPO(driver);
		return loginPO;
	}
	public homePO getHomePage()
	{
		homePO = new homePO(driver);
		return homePO;
	}
	public eventPO getEventPage()
	{
		eventPO = new eventPO(driver);
		return eventPO;
	}
}
