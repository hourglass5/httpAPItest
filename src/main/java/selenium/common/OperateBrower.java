package selenium.common;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OperateBrower {
    static WebDriver driver;

    public static WebDriver OpenfireFox() {
//		File firefoxFile = new File("E:\\\\Mozilla Firefox\\\\firefox.exe");
//		FirefoxBinary binary = new FirefoxBinary(firefoxFile);
//		driver = new FirefoxDriver(binary, null);
        System.setProperty("webdriver.firefox.bin", "D:\\Firefox\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "E:\\java\\learn_2019\\geckodriver.exe");
        driver = new FirefoxDriver();
        return driver;
    }

    public static void OpenURL(String url) {
        // 打开网页
        driver.get(url);
        // 最大屏
        driver.manage().window().maximize();
    }

    public static WebDriver OpenChrome() {
        // chrome驱动程序
        System.setProperty("webdriver.chrome.driver", "E:\\java\\learn_2019\\chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
    public static void CloseBrower() {
        driver.close();
    }

    public static void main(String[] args) throws Exception {
//        OperateBrower.OpenfireFox();
//        OperateBrower.OpenURL("https://www.baidu.com");
        OperateBrower.OpenChrome();
        OperateBrower.OpenURL("https://www.baidu.com");
//		OperateBrower.CloseBrower();
    }
}