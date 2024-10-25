package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AllCurrencypage {

    public AllCurrencypage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }
    @FindBy (id = "com.smartwho.SmartAllCurrencyConverter:id/b1")
    public WebElement bir;

    @FindBy (id = "com.smartwho.SmartAllCurrencyConverter:id/b00")
    public WebElement ikisifir;

    @FindBy (id = "com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB")
    public WebElement sonucalani;








}
