import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ExampleTestsAdditionals {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkClickScooterLogo() {

        String actual = new MainPage(driver)
                .open()
                .clickScooterLogo();

        assertEquals("Переход на главную страницу 'Самоката' не выполнен!","https://qa-scooter.praktikum-services.ru/",actual);

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
