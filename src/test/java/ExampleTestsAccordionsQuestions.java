import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.MainPage;

import java.time.Duration;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ExampleTestsAccordionsQuestions {
    private WebDriver driver;

    private final String accordionItem;
    private final String accordionItemText;
    private final String expected;

    public ExampleTestsAccordionsQuestions(String accordionItem, String accordionItemText, String expected) {
        this.accordionItem = accordionItem;
        this.accordionItemText = accordionItemText;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"0", "0",
                 "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},

                {"1", "1",
                 "Пока что у нас так: один заказ — один самокат. " +
                 "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},

                {"2", "2",
                 "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                 "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                 "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."}

        };
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void accordionItemExists() {
        MainPage mainPage = new MainPage(driver);
        String actual = mainPage
                .open()
                .clickCookieButton()
                .clickAccordionItem(accordionItem)
                .getAccordionItemText(accordionItemText);

        assertEquals(expected, actual);
    }


    @After
    public void tearDown() {
            driver.quit();
    }
}
