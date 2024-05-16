package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderModalPage {
    private final WebDriver driver;

    //Кнопка «ДА»
    private final By orderModalConfirmButton = By.xpath(".//button[text()='Да']");
    //Кнопка «НЕТ»
    private final By orderModalCancelButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Нет']");

    public OrderModalPage(WebDriver driver) {
        this.driver = driver;
    }

    //Нажать на кнопку «ДА»
    public OrderModalConfirmPage orderModalConfirmButtonClick(){
        driver.findElement(orderModalConfirmButton).click();
        return new OrderModalConfirmPage(driver);
    }

    //Нажать на кнопку «НЕТ»
    public RentPage orderModalCancelButtonClick(){
        driver.findElement(orderModalConfirmButton).click();
        return new RentPage(driver);
    }
}
