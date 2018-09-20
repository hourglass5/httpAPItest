package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

/**
 * Hello world!
 *
 */
public class Appium1
{
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        // 设置测试的操作系统，IOS/Android/FirefoxOS
        capabilities.setCapability("platformName", "Android");
        // 设置测试的操作系统版本
        capabilities.setCapability("platformVersion", "6.0");
        // 设置设备的序列号
        capabilities.setCapability("deviceName", "emulator-5554");
        // 使用的自动化测试引擎，Appium（默认）或Selendroid
        capabilities.setCapability("automationName", "Appium");

        // 设置apk的包名
        capabilities.setCapability("appPackage", "com.android.calculator2");
        // 设置启动Activity
        capabilities.setCapability("appActivity", "com.android.calculator2/com.android.calculator2.Calculator");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("5")).click();
        driver.findElement(By.name("9")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.name("+")).click();
        driver.findElement(By.name("6")).click();
        driver.findElement(By.name("=")).click();
        Thread.sleep(2000);

        String result = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
        System.out.println(result);

        driver.quit();
    }
}