package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentPage {
    private final WebDriver driver;

    //Поле ввода даты «Когда привезти самокат»
    private final By datePickerInput = By.xpath(".//div[@class='react-datepicker__input-container']//input");
    //Поле ввода «Срок аренды»
    private final By rentPeriod = By.xpath(".//div[@class='Dropdown-control']");
    //Поле ввода «Комментарий»
    private final By commentInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='Комментарий для курьера']");
    //Кнопка «Заказать»
    private final By orderRentButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");


    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнить поле даты «Когда привезти самокат» текущей датой + 1 день
    public RentPage sendDatePickerInput(){
        LocalDate date = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dataValue = date.format(formatter);
        driver.findElement(datePickerInput).sendKeys(dataValue);
        driver.findElement(datePickerInput).sendKeys(Keys.ENTER);
        return this;
    }

    //Выбрать значение из выпадающего списка «Срок аренды»
    public RentPage selectRentPeriod(String rentValue){
        WebElement dropdown = driver.findElement(rentPeriod);
        dropdown.click();
        WebElement option = driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='" + rentValue + "']"));
        option.click();
        return this;
    }

    //Выбрать значение цвета
    public RentPage sendColorCheckboxInput(String colorCheckbox){
        driver.findElement(By.xpath(".//input[@class='Checkbox_Input__14A2w' and @id='" + colorCheckbox + "']")).click();
        return this;
    }

    //Заполнить поле «Комментарий»
    public RentPage sendFieldCommentInput(String comment){
        driver.findElement(commentInput).sendKeys(comment);
        return this;
    }

    //Нажать на кнопку «Заказать»
    public OrderModalPage orderRentButtonClick(){
        driver.findElement(orderRentButton).click();
        return new OrderModalPage(driver);
    }




}
