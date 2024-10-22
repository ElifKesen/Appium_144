package day02;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Arabam {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void SetUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");//cihazin adi
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//cihazin android olmasini tanimladik
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");//Android in versiyonunu yazdik
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");// cihazin otomasyonunun saglamak icin. IOS icin XCUITest yazilacak
       // caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\Elif Kesen\\IdeaProjects\\Appium_144\\Apps\\arabam-com-5-4-1.apk");
        caps.setCapability("appPackage", "com.dogan.arabam");
        // AppPackage uzerinde caliscak oldugumuz uygulamanin kimlik bilgisidir. Apk infodan kimlik bilgisi bulunur
        caps.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");
        //calisacagimiz sayfaya direkt ulasalim diye bu activity bize gerekiyor.

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void test1() throws InterruptedException {
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        Thread.sleep(2500);

        // uygulamanin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());
        Thread.sleep(2500);

        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();

        // kategori olarak otomobil secilir
        driver.findElementByXPath("//*[@text='Otomobil']").click();

        // arac olarak Volkswagen secilir
       Thread.sleep(2000);
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(528,1801)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).
                // baslangic noktasiyla bitis noktasi arasindaki gecen sure
                // eger sure azalirsa; gidilen yol mesafesi ARTAR. eger sureyi arttirirsan; gidilen yol mesafesi AZALIR !!
                // yani tamamen bir ters oranti vardir. ekranda daha fazla asagi ya da yukari gitmek istiyorsak birim zamanda sureyi azaltmaliyiz
                moveTo(PointOption.point(528,528))
                .release()
                .perform();
        //press yaptik, cünkü kaydirmaya baslamadan önce ekrana dokunmamiz gerekiyor

        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='Volkswagen']").click();

       // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();

        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Comfortline']").click();

        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir




        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir

    }















}
