package selenium.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductRegister_page {
    WebDriver driver;

    // 借款人信息
    @FindBy(id = "name")
    WebElement inBborrowerName;
    @FindBy(id = "idCardNo")
    WebElement inCertificateNum;
    // 填写标的信息
    @FindBy(id = "keyword")
    WebElement inKeyword;
    @FindBy(id = "projectName")
    WebElement inProjectName;
    @FindBy(id = "amount")
    WebElement inAmount;
    @FindBy(id = "projectBeginTime")
    WebElement inProjectBeginTime;
    @FindBy(id = "repayRate")
    WebElement inRepayRate;
    @FindBy(id = "investDuration")
    WebElement inInvestDuration;
    @FindBy(xpath = "//input[@name='project.remarks']")
    WebElement inRemarks;
    @FindBy(id = "applyReg")
    WebElement clickApplyReg;

    public ProductRegister_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputBorrowerName(String borrowerName) {
        inBborrowerName.clear();
        inBborrowerName.sendKeys(borrowerName);
    }

    public void inputCertificateNum(String certificateNum) {
        inCertificateNum.clear();
        inCertificateNum.sendKeys(certificateNum);
    }

    public void inputKeyword(String keyword) {
        Select select = new Select(inKeyword);
        select.selectByVisibleText(keyword);
    }

    public void inputProjectName(String projectName) {
        inProjectName.clear();
        inProjectName.sendKeys(projectName);
    }

    public void inputAmount(String amount) {
        inAmount.clear();
        inAmount.sendKeys(amount);
    }

    public void inputProjectBeginTime(String projectBeginTime) {
        inProjectBeginTime.clear();
        inProjectBeginTime.sendKeys(projectBeginTime);
    }

    public void inputRepayRate(String repayRate) {
        inRepayRate.clear();
        inRepayRate.sendKeys(repayRate);
    }

    public void inputInvestDuration(String investDuration) {
        inInvestDuration.clear();
        inInvestDuration.sendKeys(investDuration);
    }

    public void inputInRemarks(String remarks) {
        inRemarks.clear();
        inRemarks.sendKeys(remarks);
    }

    public void clickApplyReg() {
        clickApplyReg.click();
    }

}