package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    //«URL»
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";

    //Кнопка «Заказать» в хедере страницы
    private final By orderHeaderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Кнопка «Заказать» в футере страницы
    private final By orderFooterButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Кнопка «Статус заказа»
    private final By checkOrderButton = By.xpath(".//button[@class='Header_Link__1TAG7']");
    //Поле ввода «Номера заказа»
    private final By orderNumberInput = By.xpath(".//input[contains(@class, 'Input_Input__1iN_Z')]");
    //Кнопка «GO»
    private final By goButton = By.xpath(".//button[text()='Go!']");
    //Кнопка куки «да все привыкли»
    private final By cookieButton = By.xpath(".//button[@id='rcc-confirm-button']");
    //Локатор логотипа самоката
    private final By scooterLogo = By.xpath("//img[@alt = 'Scooter']");
    //Локатор полной загрузки страницы Самоката
    private final By scooterPageFlag = By.className("App_App__15LM-");


    private final WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Открыть «URL»
    public MainPage open() {
        driver.get(URL);
        return this;
    }

    //Нажать на кнопку «Статус заказа»
    public MainPage clickCheckOrder() {
        driver.findElement(checkOrderButton).click();
        return this;
    }

    //Нажать на кнопку «Заказать» в хедере страницы
    public OrderPage clickOrderHeaderButton() {
        driver.findElement(orderHeaderButton).click();
        return new OrderPage(driver);
    }

    //Нажать на кнопку «Заказать» в футере страницы
    public OrderPage clickOrderFooterButton() {
        WebElement element = driver.findElement(orderFooterButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderFooterButton).click();
        return new OrderPage(driver);
    }

    //Ввод текста в поле «Номера заказа»
    public MainPage inputOrderNumberInField(String text) {
        driver.findElement(orderNumberInput).sendKeys(text);
        return this;
    }

    //Нажать на аккордеон в «Вопросы о важном»
    public MainPage clickAccordionItem(String accordionItem) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='accordion__heading-" + accordionItem + "']")));
        driver.findElement(By.xpath(".//div[@id='accordion__heading-" + accordionItem + "']")).click();
        return this;
    }

    //Получить текст из аккордеона в «Вопросы о важном»
    public String getAccordionItemText(String accordionItemText){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//div[@id='accordion__panel-"+ accordionItemText + "']/p")));
        return driver.findElement(By.xpath(".//div[@id='accordion__panel-"+ accordionItemText + "']/p")).getText();
    }

    //Нажать на кнопку куки «да все привыкли»
    public MainPage clickCookieButton(){
        driver.findElement(cookieButton).click();
        return this;
    }

    public String clickScooterLogo(){

        driver.findElement(scooterLogo).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(scooterPageFlag));

        return driver.getCurrentUrl();
    }


}


