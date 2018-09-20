package appium;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Hello world!
 *
 */
public class AppiumJinniuguanjia
{
    private AppiumDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        // 指定测试平台
        cap.setCapability("platformName", "Android");
        // 指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("deviceName", "SALDU17429004258");
        // 设置测试的操作系统版本
        cap.setCapability("platformVersion", "8.0.0");

        // 解决每次测试都重新安装app
        cap.setCapability("noReset", true);

        // 将上面获取到的包名和Activity名设置为值
        // 金牛管家
        cap.setCapability("appPackage", "com.lianqian.jinniuguanjia");
//		cap.setCapability("appActivity", ".moudles.home.MainActivity");
        // 登录页面
        cap.setCapability("appActivity", ".moudles.login_register.LoginAndRegisterActivity");

        // 淘宝
//		cap.setCapability("appPackage", "com.taobao.taobao");
//		cap.setCapability("appActivity", "com.taobao.tao.homepage.MainActivity3");

        // A new session could not be created的解决方法
//		cap.setCapability("appWaitActivity", "com.lianqian.jinniuguanjia/com.lianqian.jinniuguanjia.moudles.home.MainActivity");
        // 每次启动时覆盖session，否则第二次后运行会报错不能新建session
        cap.setCapability("sessionOverride", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

    @Test
    public void plus() {

        // 点击“记事”
//		driver.findElementById("com.lianqian.jinniuguanjia:id/tv_home_item_title").click();
//		driver.findElementByClassName("android.widget.LinearLayout").click();

    }

    //	@AfterClass
    public void tearDown() {

        driver.quit();

    }
}