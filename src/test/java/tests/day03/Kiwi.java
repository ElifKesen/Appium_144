package tests.day03;

import Pages.KiwiPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class Kiwi {
// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
// gidis tarihi ekim ayinin 30 u olarak secilir ve set date e tiklanir
// search butonuna tiklanir
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    KiwiPage page = new KiwiPage();

    @Test
    public void kiwitest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        Thread.sleep(2000);

        //uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(page.misafirolarakdevambutonu.isDisplayed());

        // misafir olarak devam et e tiklanir
        page.misafirolarakdevambutonu.click();
        Thread.sleep(2000);

        // ardindan gelecek olan 3 adimda da yesil butona basilarak devam edilir

        /*TouchAction action = new TouchAction<>(driver);
        Thread.sleep(2000);
        for (int i = 0; i < 3; i++) {
            action.press(PointOption.point(529, 2049)).release().perform();
            Thread.sleep(500);

         */
        for (int i = 0; i < 3; i++) {
            ReusableMethods.nextTiklamaMethodu(529, 2049, 500);
        }

            // Trip type,one way olarak secilir
        page.returnbutonu.click();
        page.onewaybutonu.click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        page.frombutonu.click();
        page.clearbutonu.click();

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        page.kalkisYazmakutusu.click();

        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Ankara");
        }else {
            page.kalkisYazmakutusu.sendKeys("Ankara");
        }






        }
    }















