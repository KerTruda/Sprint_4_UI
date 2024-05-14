package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private final WebDriver driver;

    //Поле ввода «Имени»
    private final By firstName = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']");
    //Поле ввода «Фамилии»
    private final By lastName = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Фамилия']");
    //Поле ввода «Адреса»
    private final By placeName = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Адрес: куда привезти заказ']");
    //Поле ввода «Номера телефона»
    private final By phoneNumber = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка «Далее»
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле ввода «Станции метро»
    private final By stationInput = By.xpath(".//input[@class='select-search__input']");



    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Нажать на кнопку «Далее»
    public RentPage clickNextButton(){
        driver.findElement(nextButton).click();
        return new RentPage(driver);
    }

    //Заполнить обяательные поля на странице «Для кого самокат»
    public OrderPage sendFields(String firstName, String lastName, String placeName, String phoneNumber){
        driver.findElement(this.firstName).sendKeys(firstName);
        driver.findElement(this.lastName).sendKeys(lastName);
        driver.findElement(this.placeName).sendKeys(placeName);
        driver.findElement(this.phoneNumber).sendKeys(phoneNumber);

        return this;
    }

    //Выбрать станцию метро из выпадающего списка
    public OrderPage selectStation(String stationValue){
        WebElement dropdown = driver.findElement(stationInput);
        dropdown.click();
        WebElement option = driver.findElement(By.xpath(".//button[@class='Order_SelectOption__82bhS select-search__option' and @value='" + stationValue + "']"));
        option.click();
        return this;
    }

}