package PagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import java.time.Duration;

public class QuestionsPage {
    private WebDriver driver;
    private By sectionQuery;
    private By sectionAnswer;
    public QuestionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToQuestionsSections(){
        WebElement element = driver.findElement(By.xpath(".//div[text()='Вопросы о важном']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Вопросы о важном']")));
    }

    public boolean checkTheAnswer(String question, String answer){
        sectionQuery = By.xpath(".//div[text()='"+question+"']");
        driver.findElement(sectionQuery).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[text()='"+answer+"']")));
        sectionAnswer = By.xpath(".//p[text()='"+answer+"']");
        boolean resultcheck = false;
        if (driver.findElement(sectionAnswer).getText().equals(answer)){resultcheck = true;}
        return resultcheck;
    }

//.//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']


//         .//div[text()='Сколько это стоит? И как оплатить?']
}
