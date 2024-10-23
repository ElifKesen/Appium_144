package tests.day03;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ToDoList {
    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void SetUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");//cihazin adi
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//cihazin android olmasini tanimladik
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");//Android in versiyonunu yazdik
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");// cihazin otomasyonunun saglamak icin. IOS icin XCUITest yazilacak
        caps.setCapability("appPackage", "todolist.scheduleplanner.dailyplanner.todo.reminders");
        caps.setCapability("appActivity", "app.todolist.activity.SplashActivity");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
@Test
    public void toDoList() throws InterruptedException {
    // uygulamanin basarili bir sekilde yuklendigi dogrulanir
    Assert.assertTrue(driver.isAppInstalled("todolist.scheduleplanner.dailyplanner.todo.reminders"));
    Thread.sleep(2500);

// uygulaminin basarili bir sekilde acildigi dogrulanir
driver.findElementByXPath("//*[@text='Welcome to To-do List']").isDisplayed();
    Thread.sleep(2500);

// Ileri butonlarina tiklanir ve pop-up lar kapatilir
driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/honor_continue").click();
driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/welcome_start").click();
driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/toolbar_back").click();
driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/dialog_pro_first_close").click();
    Thread.sleep(2000);

// görev ekleme adimina gecilir

   driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/iv_task_add").click();;
    Thread.sleep(2000);

// görev adi girilir
    driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_create_input").sendKeys("cicekleri sula");
    Thread.sleep(2000);

// görev kaydedilir
    driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_create_btn").click();

    TouchAction action=new TouchAction<>(driver);
    Thread.sleep(2000);
    for (int i = 0; i <3 ; i++) {
        action.press(PointOption.point(806,1206)).release().perform();
    }



// görev silinir
    driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_text").click();
    driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_detail_more").click();
    driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/detail_delete").click();
    driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/dialog_confirm").click();
    Thread.sleep(2000);

// Görev olusturma sayfasina geri dönüldügü dogrulanir
    Assert.assertTrue(driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_none").isDisplayed());






}

}
