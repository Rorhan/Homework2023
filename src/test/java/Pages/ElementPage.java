package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementPage extends PageObject {
    @FindBy(name = "search")
    public WebElement search;

    @FindBy(xpath = "//i[@class='fa fa-search']")
    public WebElement clickSearchButton;

    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    public WebElement message;

    @FindBy(linkText = "iPhone")
    public WebElement iphone;

    @FindBy(xpath = "//*[@id='content']/div[1]/div[2]/h1")
    public WebElement dogruUrunMesaji;

    @FindBy(css = "#button-cart")
    public WebElement addToCart;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement urunEklendiMesaji;
}



    //********Metodlar*******

   /* public void login(){

        username.sendKeys(ConfigReader.getProperties("username"));
        password.sendKeys(ConfigReader.getProperties("password"));
        loginButton.click();
    }

    */


   /* public String getUserNameText(){
        String username=userValue.getText();
        return username;
    }

}

    */
