package selenium.common;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OperateBrower {
    static WebDriver driver;

    public static WebDriver OpenfireFox() throws IOException {
//		File firefoxFile = new File("E:\\\\Mozilla Firefox\\\\firefox.exe");
//		FirefoxBinary binary = new FirefoxBinary(firefoxFile);
//		driver = new FirefoxDriver(binary, null);
        System.setProperty("webdriver.firefox.bin", "E:\\Mozilla Firefox_new\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "E:\\Java\\workspace_0517\\geckodriver.exe");
        driver = new FirefoxDriver();
        return driver;
    }

    public static void OpenURL(String url) throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void CloseBrower() {
        driver.close();
    }

    public static void main(String[] args) throws Exception {
        OperateBrower.OpenfireFox();
        OperateBrower.OpenURL("https://www.baidu.com");
//		OperateBrower.CloseBrower();
    }
}