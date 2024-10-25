package tests.day05;

import Pages.AllCurrencypage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class AllCurrency {

// cevrilen tutar screenShot olarak kaydedilir
// Ardindan japon yeni nin tl karsiligi olan tl degeri kaydedilir
// kullaniciya sms olarak bildirilir

AndroidDriver<AndroidElement>driver= Driver.getAndroidDriver();
AllCurrencypage page=new AllCurrencypage();

    @Test
    public void allcurrencyTest() throws InterruptedException {
        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));
        // uygulamanin acildigi dogrulanir
        Assert.assertTrue(driver.findElementByXPath("//*[@text='CURRENCY CONVERTER']").isDisplayed());

        // cevirmek istedigimiz para birimi japon yen'i olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(393,463,500);
        ReusableMethods.scrollWithUiScrollableAndClick("JPY");

        // cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(384,642,500);
        ReusableMethods.scrollWithUiScrollableAndClick("Turkish Lira");

        // cevrilen tutar screenShot olarak kaydedilir
        page.bir.click();
        page.ikisifir.click();




    }

}
