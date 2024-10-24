package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {

    public static void nextTiklamaMethodu(int xkoordinati, int ykoordinati, int beklemesuresi) throws InterruptedException {
        try {
            TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
            Thread.sleep(2000);
            for (int i = 0; i < 3; i++) {
                action.press(PointOption.point(xkoordinati, ykoordinati))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .release().perform();
                Thread.sleep(beklemesuresi);
            }
        } catch (InvalidElementStateException e) {
            System.out.println("InvalidElementStateException: " + e.getMessage());

        }
    }

}
