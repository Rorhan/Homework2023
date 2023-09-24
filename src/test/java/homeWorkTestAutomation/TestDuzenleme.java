package homeWorkTestAutomation;

import Pages.ElementPage;
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






        Driver.closeDriver();


    }
}
