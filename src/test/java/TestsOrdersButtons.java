import BaseTest.MainTest;
import PagePackage.MainPage;
import PagePackage.RentPage;
import PagePackage.ScooterOwnerPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class TestsOrdersButtons {
    private WebDriver driver;
//    @Before
////    Открытие браузера Firefox
//    public void launchMozilaFireFox(){
//        System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//        MainTest mainTest = new MainTest("FireFox");
//        driver = mainTest.createDriver();
//    }

    @Before
//    Открытие браузера Google Chrome
    public void launchGoogleChrome(){
//        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        MainTest mainTest = new MainTest("Chrome");
        driver = mainTest.createDriver();

    }
//    Выполнение алгоритма из верхней кнопки "Заказать"
    @Test
    public void testTopOrderButton() throws Exception {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.pushTopOrderButton();
        ScooterOwnerPage scooterOwnerPage = new ScooterOwnerPage(driver);
        scooterOwnerPage.waitForLoadHeader();
        scooterOwnerPage.insertInToNamePlaceHolder("Ольга");
        scooterOwnerPage.insertInToFamilyPlaceHolder("Иванова");
        scooterOwnerPage.insertInToDeliveryAddressPlaceHolder("ул. Пушкина д.Колотушкина");
        scooterOwnerPage.changeMetroStation("Сокольники");
        scooterOwnerPage.insertInToPhonePlaceHolder("891234567890");
        scooterOwnerPage.pushcontinueButton();
        RentPage rentPage = new RentPage(driver);
        rentPage.waitForLoadHeader();
        rentPage.changeDeliveryDate("02.01.2024");
        rentPage.changeRentalPeriod("пятеро суток");
        rentPage.changeColor("серая безысходность");
        rentPage.completeTheOrder();
        rentPage.setApprovedRent();
    }
    //    Выполнение алгоритма из нижней кнопки "Заказать"
    @Test
    public void testBottomOrderButton() throws Exception {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.pushBottomOrderButton();
        ScooterOwnerPage scooterOwnerPage = new ScooterOwnerPage(driver);
        scooterOwnerPage.waitForLoadHeader();
        scooterOwnerPage.insertInToNamePlaceHolder("Иван");
        scooterOwnerPage.insertInToFamilyPlaceHolder("Никитин");
        scooterOwnerPage.insertInToDeliveryAddressPlaceHolder("ул. Соколова д.123");
        scooterOwnerPage.changeMetroStation("Черкизовская");
        scooterOwnerPage.insertInToPhonePlaceHolder("891234500000");
        scooterOwnerPage.pushcontinueButton();
        RentPage rentPage = new RentPage(driver);
        rentPage.waitForLoadHeader();
        rentPage.changeDeliveryDate("03.06.2024");
        rentPage.changeRentalPeriod("сутки");
        rentPage.changeColor("чёрный жемчуг");
        rentPage.completeTheOrder();
        rentPage.setApprovedRent();
    }

    @After
    public void teardown() {
        // Закрытие браузера
        driver.quit();
    }
}
