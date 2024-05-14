package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderModalConfirmPage {
    private final WebDriver driver;

    //Локатор текста «Заказ оформлен»
    private final By orderModalConfirmText = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderModalConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    //Проверка отображения «Заказ оформлен»
    public boolean isOrderCreate(){

        return driver.findElement(orderModalConfirmText).isDisplayed();

    }
}
