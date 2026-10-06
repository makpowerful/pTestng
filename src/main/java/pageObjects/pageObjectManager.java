package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	private final WebDriver driver;
	public LoginPO loginPO;
	public HomePO homePO;
	public EventPO eventPO;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LoginPO getLoginPage()
	{
		loginPO = new LoginPO(driver);
		return loginPO;
	}
	public HomePO getHomePage()
	{
		homePO = new HomePO(driver);
		return homePO;
	}
	public EventPO getEventPage()
	{
		eventPO = new EventPO(driver);
		return eventPO;
	}
}
