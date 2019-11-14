package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    @FindBy (xpath = "//div[@class='login-btn']")
    private WebElement loginButton;

    @FindBy (xpath = "//[@id='basic-navbar-nav']/div[@class='ml-auto-navbar']/div")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[@class='register-btn']/a")
    private WebElement registerBtn;

    public void clickElement(By locator){
        getClickable(locator).click();
    }

    public void clickOnLogin() {
        wait.until(ExpectedConditions.visibilityOf(this.loginButton));
        this.loginButton.click();
    }

    public void openRegisterModal(){
        registerBtn.click();
    }

    public boolean logoutBtnAppears(){
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        return logoutButton.isDisplayed();
    }

}
