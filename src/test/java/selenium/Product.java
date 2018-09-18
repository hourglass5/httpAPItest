package selenium;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import selenium.common.OperateBrower;
import selenium.pageobject.Denglu_page;
import selenium.pageobject.ProductRegister_page;

public class Product {
    WebDriver driver;
    Denglu_page denglu_page;
    ProductRegister_page productRegister_page;

    @BeforeClass
    public void setUp() throws Exception {
        driver = OperateBrower.OpenfireFox();
        OperateBrower.OpenURL("http://120.27.13.190:8080/xhjd/Product/loginBackground.jsp");
    }

    @Test
    public void testProduct() throws InterruptedException {
        // 登录
        denglu_page = new Denglu_page(driver);
        denglu_page.denglu("15112304365", "123456", "111111");

        // OperateBrower.OpenURL("http://120.27.13.190:8080/xhjd/Product/Admin/project!queryProjectList.action");
        // WebDriverWait wait = new WebDriverWait(driver,10);
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='submit']"))));
        // 点击"标的登记"
        // driver.findElement(By.xpath("//input[@type='submit']")).click();

        OperateBrower.OpenURL("http://120.27.13.190:8080/xhjd/Product/Admin/project!addProject.action?");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("name"))));

        productRegister_page = new ProductRegister_page(driver);

        // 点击【查询】
        driver.findElement(By.cssSelector("button.research")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button.certain"))));
        // 选择借款人
        driver.findElement(By.xpath("//table/tbody/tr/td[@data-id='6']")).click();
        // 点击“确定”
        driver.findElement(By.cssSelector("button.certain")).click();

        // 设置日期格式
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat date1 = new SimpleDateFormat("MMdd");

        productRegister_page.inputKeyword("新华2号季标");
        productRegister_page
                .inputProjectName("新华2号季标No." + date1.format(new Date()) + "-" + (int) (10 + Math.random() * (99 - 10 + 10)));
        productRegister_page.inputAmount("10000");
        productRegister_page.inputProjectBeginTime(date.format(new Date()));
        productRegister_page.inputRepayRate("15");
        productRegister_page.inputInvestDuration("90");
        productRegister_page.inputInRemarks("购物消费");
        // 申请登记
        productRegister_page.clickApplyReg();

        Alert alt = driver.switchTo().alert();
        alt.accept();
    }

    @AfterClass
    public void tearDown() {
        OperateBrower.CloseBrower();
    }
}