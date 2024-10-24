package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPage {

  public KiwiPage(){
      PageFactory.initElements((WebDriver)Driver.getAndroidDriver(),this);
  }

  @FindBy(xpath="(//*[@class='android.widget.Button'])[4]")
    public WebElement misafirolarakdevambutonu;

  @FindBy(xpath="//*[@text='Return']")
  public WebElement returnbutonu;

  @FindBy(xpath="//*[@text='One way']")
  public WebElement onewaybutonu;

  @FindBy(xpath="//*[@text='From:']")
  public WebElement frombutonu;

  @FindBy(xpath="//*[@accessibility id='Clear All']")
  public WebElement clearbutonu;

  @FindBy(xpath="//*[@class='android.widget.EditText']")
  public WebElement kalkisYazmakutusu;

  }





