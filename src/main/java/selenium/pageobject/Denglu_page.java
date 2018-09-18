package selenium.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Denglu_page {
    WebDriver driver;

    // 账户
    @FindBy(id = "username")
    WebElement inUsername;
    // 密码
    @FindBy(id = "password")
    WebElement inPassword;
    // 获取验证码
    @FindBy(id = "getValidate")
    WebElement getValidate;
    // 验证码
    @FindBy(id = "validate")
    WebElement inValidate;
    // 登录
    @FindBy(xpath = "//input[@class='input login-btn']")
    WebElement inbutton;

    public Denglu_page(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    public void inputUsername(String username) {
        inUsername.clear();
        inUsername.sendKeys(username);
    }

    public void inputPassword(String password) {
        inPassword.clear();
        inPassword.sendKeys(password);
    }

    public void getValidate() {
        getValidate.click();
    }

    public void inputValidate(String validate) {
        inValidate.clear();
        inValidate.sendKeys(validate);
    }

    public void clickButton() {
        inbutton.click();
    }

    public void denglu(String name,String password,String validate) {
        inputUsername(name);
        inputPassword(password);
//		getValidate();
        inputValidate(validate);
        clickButton();
    }
}