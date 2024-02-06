package PagePackage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private By orderStatusButton = By.className("Header_Link__1TAG7");
    private List<WebElement> elements;
    public MainPage(WebDriver driver) {

        this.driver = driver;
        elements = driver.findElements(By.xpath(".//button[text()='Заказать']"));
    }


//    Метод нажатия на верхнюю кнопку "Заказать"
    public void pushTopOrderButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(elements.get(0)));
        elements.get(0).click();
    }
//    Метод нажатия на нижнюю кнопку "Заказать"
    public void pushBottomOrderButton(){
        WebElement webelement = elements.get(1);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webelement);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(webelement));
        webelement.click();
    }
//Метод нажатия на кнопку "Статус заказа"
    public void pushOrderStatusButton(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(orderStatusButton).click();
    }


}
