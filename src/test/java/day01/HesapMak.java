package day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HesapMak {

  AndroidDriver<AndroidElement>driver;

  @Test
  public void deneme() throws MalformedURLException {
    DesiredCapabilities caps =new DesiredCapabilities();
    caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4");//cihazin adi
    //caps.setCapability("deviceName","Pixel 4");
    caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");//cihazin android olmasini tanimladik
    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");//Android in versiyonunu yazdik
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");// cihazin otomasyonunun saglamak icin
    //versiyonu 6.0 dan kücük olanalr icin UiAutomator yazilacask, sonunda 2 olmayacak
    caps.setCapability(MobileCapabilityType.APP,"C:\\Users\\Elif Kesen\\IdeaProjects\\Appium_144\\Apps\\Calculator_8.4 (503542421)_Apkpure (3).apk");

    driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


  }

}
