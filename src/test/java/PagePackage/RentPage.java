package PagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class RentPage {
    private WebDriver driver;

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By deliveryDate = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    private By rentalPeriod = By.className("Dropdown-control");
    private By colorBlack = By.id("black");
    private By colorGrey = By.id("grey");
    private By approvedRent = By.xpath(".//button[text()='Да']");
    private By orderCompletionButton = By.xpath(".//div[starts-with(@class,'Order_Buttons')]/button[text()='Заказать']");

    public void changeDeliveryDate(String delDate) {
        driver.findElement(deliveryDate).sendKeys(delDate);
        driver.findElement(deliveryDate).sendKeys(Keys.RETURN);
    }

    public void waitForLoadHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Про аренду']")));
    }

    public void changeRentalPeriod(String userRentalPeriod) {
        driver.findElement(rentalPeriod).click();
        driver.findElement(By.xpath(".//div[text()='" + userRentalPeriod + "']")).click();
    }

    public void changeColor(String color) throws Exception {
        if (color.equals("чёрный жемчуг")) {
            driver.findElement(colorBlack).click();
        } else if (color.equals("серая безысходность")) {
            driver.findElement(colorGrey).click();
        } else {
            throw new Exception("Выбран не верный цвет: " + color);
        }
    }

    public void completeTheOrder() {
        driver.findElement(orderCompletionButton).click();
    }

    public void setApprovedRent() {
        driver.findElement(approvedRent).click();
        assertTrue(driver.findElement(By.xpath(".//div[text()='Заказ оформлен']")).isDisplayed());
    }
}



