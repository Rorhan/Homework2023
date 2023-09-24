package homeWorkTestAutomation;



import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://tutorialsninja.com/demo/");

        driver.manage().window().fullscreen();

        Thread.sleep(3000);

        WebElement searchBoxElement = driver.findElement(By.name("search"));
        searchBoxElement.sendKeys("iPhone");


        Thread.sleep(2000);


        WebElement clickSearchButton = driver.findElement(By.xpath("//i[@class='fa fa-search']"));
        clickSearchButton.click();

        Thread.sleep(3000);


        WebElement message = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        System.out.println("message.getText() = " + message.getText());
        String actualMessage = message.getText();
        String expectedMessage = "Search - iPhone";
        Assert.assertEquals(actualMessage, expectedMessage, "MESAJLAR AYNI DEGIL!");

        WebElement urunClick = driver.findElement(By.linkText("iPhone"));
        urunClick.click();
        Thread.sleep(2000);

        WebElement dogruUrunMesaji = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/h1"));
        System.out.println("dogruUrunMesaji.getText() = " + dogruUrunMesaji.getText());
        String actualMessageOfProduct = dogruUrunMesaji.getText();
        String expectedMessageOfProduct = "iPhone";
        Assert.assertEquals(actualMessageOfProduct, expectedMessageOfProduct, "DOGRU URUN MESAJI DEGIL!");

        WebElement addToCart = driver.findElement(By.cssSelector("#button-cart"));
        addToCart.click();
        Thread.sleep(2000);

        WebElement urunEklendiMesaji = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")); //  ////div[text()='Success: You have added ']
        System.out.println("urunEklendiMesaji.getText() = " + urunEklendiMesaji.getText());
        String actualMessageofAddToCard = urunEklendiMesaji.getText();
        String expectedMessageOfAddToCard = "Success: You have added iPhone to your shopping cart!\n×";
        Assert.assertEquals(actualMessageofAddToCard, expectedMessageOfAddToCard, "YANLIS MESAJ!");
        Thread.sleep(2000);


        driver.close();
    }

}
