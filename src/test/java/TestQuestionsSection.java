import BaseTest.MainTest;
import PagePackage.QuestionsPage;
import org.junit.After;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestQuestionsSection {
    private final String qusetion;
    private final String answer;
    private final boolean isTruth;
    private WebDriver driver;

    public TestQuestionsSection( String qusetion, String answer, boolean isTruth) {
        this.qusetion = qusetion;
        this.answer = answer;
        this.isTruth = isTruth;
    }

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


    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",true},
                {"Хочу сразу несколько самокатов! Так можно?","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",true},
                {"Как рассчитывается время аренды?","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",true},
                {"Можно ли заказать самокат прямо на сегодня?","Только начиная с завтрашнего дня. Но скоро станем расторопнее.",true},
                {"Можно ли продлить заказ или вернуть самокат раньше?","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",true},
                {"Вы привозите зарядку вместе с самокатом?","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",true},
                {"Можно ли отменить заказ?","Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",true},
                {"Я жизу за МКАДом, привезёте?","Да, обязательно. Всем самокатов! И Москве, и Московской области.",true},
        };

    }


    @Test
    public void checkSections(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        QuestionsPage questionsPage = new QuestionsPage(driver);
        questionsPage.scrollToQuestionsSections();
        assertThat(questionsPage.checkTheAnswer(qusetion,answer),is(isTruth));
    }


    @After
    public void teardown() {
        // Закрытие браузера
        driver.quit();
    }
}
