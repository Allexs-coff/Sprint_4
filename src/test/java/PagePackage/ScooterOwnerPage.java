package PagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ScooterOwnerPage {
    private WebDriver driver;


    private List<WebElement> elemets;
    private WebElement namePlaceHolder;
    private WebElement familyPlaceHolder;
    private WebElement deliveryAddressPlaceHolder;
    private WebElement phonePlaceHolder ;
    private By continueButton = By.xpath(".//button[text()='Далее']");
    private By listMetroStation = By.xpath(".//input[@class='select-search__input']");

    public ScooterOwnerPage(WebDriver driver) {
        this.driver = driver;
        elemets = driver.findElements(By.xpath(".//input[@type='text'  and starts-with(@placeholder,'*')]"));
        namePlaceHolder = elemets.get(0);
        familyPlaceHolder = elemets.get(1);
        deliveryAddressPlaceHolder = elemets.get(2);
        phonePlaceHolder = elemets.get(3);
    }
    public void waitForLoadHeader(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Для кого самокат']")));
    }

    public void insertInToNamePlaceHolder(String name){
        namePlaceHolder.sendKeys(name);
    }

    public void insertInToFamilyPlaceHolder(String family){
       familyPlaceHolder.sendKeys(family);
    }

    public void insertInToDeliveryAddressPlaceHolder(String address){
      deliveryAddressPlaceHolder.sendKeys(address);
    }

    public void changeMetroStation(String station){
        driver.findElement(listMetroStation).click();
        driver.findElement(By.xpath(".//div[text()=\'"+station+"\']")).click();
    }

    public void insertInToPhonePlaceHolder(String phoneNumber){
        phonePlaceHolder.sendKeys(phoneNumber);
    }

    public void pushcontinueButton(){
        driver.findElement(continueButton).click();
    }
}
