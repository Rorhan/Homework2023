package homeWorkTestAutomation;

import Pages.ElementPage;
import Pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class TestDuzenleme {
    @Test
    public void test1() throws InterruptedException {
        ElementPage elementPage=new ElementPage();

        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperties("url"));
        Thread.sleep(2000);

        elementPage.search.sendKeys("iPhone");
        Thread.sleep(2000);

        elementPage.clickSearchButton.click();
        Thread.sleep(2000);

        elementPage.message.getText();
        String actualMessage = elementPage.message.getText();
        System.out.println("actualMessage = " + actualMessage);
        String expectedMessage = "Search - iPhone";
        Assert.assertEquals(actualMessage, expectedMessage, "MESAJLAR AYNI DEGIL!");

        elementPage.iphone.click();
        Thread.sleep(2000);

        elementPage.dogruUrunMesaji.getText();
        String actualMessageOfProduct = elementPage.dogruUrunMesaji.getText();
        System.out.println("actualMessageOfProduct = " + actualMessageOfProduct);
        String expectedMessageOfProduct = "iPhone";
        Assert.assertEquals(actualMessageOfProduct, expectedMessageOfProduct, "DOGRU URUN MESAJI DEGIL!");

        elementPage.addToCart.click();
        Thread.sleep(2000);

        elementPage.urunEklendiMesaji.getText();
        String actualMessageofAddToCard = elementPage.urunEklendiMesaji.getText();
        System.out.println("actualMessageofAddToCard = " + actualMessageofAddToCard);
        String expectedMessageOfAddToCard = "Success: You have added iPhone to your shopping cart!\n×";
        Assert.assertEquals(actualMessageofAddToCard, expectedMessageOfAddToCard, "YANLIS MESAJ!");
        Thread.sleep(2000);

        Driver.closeDriver();
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = Driver.getDriver();

        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperties("url"));
        Thread.sleep(2000);

        ElementPage elementPage=new ElementPage();
        PageObject pageObject=new PageObject();
        pageObject.scrollAndClick(elementPage.addTooCardButton);
        Thread.sleep(4000);


        elementPage.controlAddCart.click();
        String actualNumber=elementPage.controlAddCart.getText();
        System.out.println("actualNumber = " + actualNumber);
        String expectedNumber="1 item(s) - $123.20";
        Assert.assertEquals(actualNumber,expectedNumber,"yanlis urun miktari!!");
        Thread.sleep(2000);

        elementPage.controlProduct.getText();
        String actualMessage=elementPage.controlProduct.getText();
        System.out.println("actualMessage = " + actualMessage);
        String expectedMessage="iPhone";
        Assert.assertEquals(actualMessage,expectedMessage,"Yanlis urun mesaji!!");
        Thread.sleep(2000);

        elementPage.clickForRemove.click();
        Thread.sleep(2000);

        elementPage.controlEmptyCart.click();
        Thread.sleep(1000);

        elementPage.controlEmptyCartMessage.getText();
        String actualEmptyCartMessage=elementPage.controlEmptyCartMessage.getText();
        System.out.println("actualEmptyCartMessage = " + actualEmptyCartMessage);
        String expectedEmptyCartMessage="Your shopping cart is empty!";
        Assert.assertEquals(actualEmptyCartMessage,expectedEmptyCartMessage,"Yanlis EmptyCart mesaji!!");
        Thread.sleep(2000);

        Driver.closeDriver();
    }
}
