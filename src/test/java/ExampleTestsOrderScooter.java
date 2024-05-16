import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.*;
import java.time.Duration;

@RunWith(Parameterized.class)
public class ExampleTestsOrderScooter {
    private WebDriver driver;

    private final String firstName;
    private final String lastName;
    private final String placeName;
    private final String phoneNumber;
    private final String stationValue;
    private final String rentValue;
    private final String colorCheckbox;
    private final String comment;

    public ExampleTestsOrderScooter(String firstName, String lastName, String placeName, String phoneNumber, String stationValue, String rentValue, String colorCheckbox, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.placeName = placeName;
        this.phoneNumber = phoneNumber;
        this.stationValue = stationValue;
        this.rentValue = rentValue;
        this.colorCheckbox = colorCheckbox;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"Андрей", "Баев", "ул. Ленина", "+79001112233", "5", "сутки", "black", "Комментарий1"},
                {"Олег", "Боев", "ул. Мира", "+79001114455", "6", "двое суток", "grey", "Комментарий2"}
        };
    }

    @Before
    public void setup() {
        /*driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/

        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();

    }



    @Test
    public void orderScooterFromHeader() {
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .clickCookieButton()
                .clickOrderHeaderButton()
                .sendFields(firstName, lastName, placeName, phoneNumber)
                .selectStation(stationValue)
                .clickNextButton()
                .sendDatePickerInput()
                .selectRentPeriod(rentValue)
                .sendColorCheckboxInput(colorCheckbox)
                .sendFieldCommentInput(comment)
                .orderRentButtonClick()
                .orderModalConfirmButtonClick()
                .isOrderCreate();

    }

    @Test
    public void orderScooterFromFooter() {
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .clickCookieButton()
                .clickOrderFooterButton()
                .sendFields(firstName, lastName, placeName, phoneNumber)
                .selectStation(stationValue)
                .clickNextButton()
                .sendDatePickerInput()
                .selectRentPeriod(rentValue)
                .sendColorCheckboxInput(colorCheckbox)
                .sendFieldCommentInput(comment)
                .orderRentButtonClick()
                .orderModalConfirmButtonClick()
                .isOrderCreate();

    }






    @After
    public void tearDown() {
        driver.quit();
    }

}
