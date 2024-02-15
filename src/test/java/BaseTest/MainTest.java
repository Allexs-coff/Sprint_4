package BaseTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class MainTest {
    private String browserName;
    private static WebDriver driver;

    public MainTest(String browserName){
        this.browserName = browserName;
    }

    public WebDriver createDriver(){
    if (browserName.contains("Chrome")){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    else if(browserName.contains("FireFox")){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    return driver;
    }




}
