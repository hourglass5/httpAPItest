package selenium;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Xinhuohu {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void beforeClass() {

        // 指定firefox的安装路径
        System.setProperty("webdriver.firefox.bin", "E:\\Mozilla Firefox\\firefox.exe");
        // Firefox驱动程序
        System.setProperty("webdriver.gecko.driver", "E:\\Java\\workspace_0517\\geckodriver.exe");
        driver = new FirefoxDriver();
        // 最大屏
        driver.manage().window().maximize();
        // 打开网页
        baseUrl = "http://114.55.157.88/xhjd/Product/Admin/login/welcome.jsp";

    }

    public void f() {
        driver.get(baseUrl);
        /**系统登录**/
        // 账户
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("15112304365");
        // 密码
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456");
        // 验证码
        driver.findElement(By.id("getValidate")).click();
        driver.findElement(By.id("validate")).clear();
        driver.findElement(By.id("validate")).sendKeys("111111");
        // 点击【登录】
        driver.findElement(By.xpath("//input[@class='input login-btn']")).click();

        /**标的登记**/
        // 进入【标的管理】页面
        driver.get("http://120.27.13.190:8080/xhjd/Product/Admin/project!queryProjectList.action");
        // 点击"标的登记"
        driver.findElement(By.id("registForm")).click();
        // 借款人信息
        driver.findElement(By.xpath("//input[@class='borrowerName']")).sendKeys("文琦七");
        driver.findElement(By.xpath("//input[@class='certificateNum']")).sendKeys("510101198804280115");
        // 填写表的信息
        // 标的关键字
        Select select = new Select(driver.findElement(By.id("keyword")));
        select.selectByVisibleText("新华2号月标");
        // 标的名称
        driver.findElement(By.id("projectName")).clear();
        driver.findElement(By.id("projectName")).sendKeys("新华2号月标No.18-r7");
        // 融资本金
        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys("10000");
        // 募集开始日
        driver.findElement(By.id("projectBeginTime")).clear();
        driver.findElement(By.id("projectBeginTime")).sendKeys("20180518");
        // 投资收益率
        driver.findElement(By.id("repayRate")).clear();
        driver.findElement(By.id("repayRate")).sendKeys("15");
        // 融资期限
        driver.findElement(By.id("investDuration")).clear();
        driver.findElement(By.id("investDuration")).sendKeys("28");
        // 借款用途
        driver.findElement(By.xpath("//input[@name='project.remarks']")).clear();
        driver.findElement(By.xpath("//input[@name='project.remarks']")).sendKeys("购物消费");
        // 点击"申请登记"
        driver.findElement(By.id("applyReg")).click();

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }

    }

}